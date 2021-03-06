/*
 * Copyright (c) 2002-2017, Mairie de Paris
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice
 *     and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice
 *     and the following disclaimer in the documentation and/or other materials
 *     provided with the distribution.
 *
 *  3. Neither the name of 'Mairie de Paris' nor 'Lutece' nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * License 1.0
 */

package fr.paris.lutece.plugins.appcenter.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.paris.lutece.plugins.appcenter.business.Application;
import fr.paris.lutece.plugins.appcenter.business.Demand;
import fr.paris.lutece.plugins.appcenter.business.DemandFilter;
import fr.paris.lutece.plugins.appcenter.business.DemandHome;
import fr.paris.lutece.portal.service.util.AppLogService;
import fr.paris.lutece.portal.service.workflow.WorkflowService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
/**
 * Demand Service
 */
public class DemandService
{
    private static final String PARAMETER_ENVIRONMENT_PREFIX  = "environment_prefix";
    private static final String PARAMETER_ID_DEMAND_TYPE  = "id_demand_type";
    private static final String PARAMETER_IS_CLOSED  = "is_closed";
    private static final String PARAMETER_ID_APPLICATION  = "id_application";
    
    private static ObjectMapper _mapper = new ObjectMapper( );
    
    public static void saveDemand ( Demand demand, Application application )
    {
    	demand.setCreationDate(new java.sql.Timestamp( ( new java.util.Date( ) ).getTime( ) ));
        demand.setDemandData( getDemandAsString( demand ) );
        DemandHome.create( demand );
        //Run the workflow
        int nIdResource = demand.getId( );
        int nIdWorkflow = DemandTypeService.getIdWorkflow( demand.getDemandType() );
        WorkflowService.getInstance( ).getState( nIdResource, Demand.WORKFLOW_RESOURCE_TYPE, nIdWorkflow, -1 );
        WorkflowService.getInstance( ).executeActionAutomatic( nIdResource, Demand.WORKFLOW_RESOURCE_TYPE, nIdWorkflow, -1 );

    }
    
    public static <T extends Demand> List<T> getDemandsListByApplicationAndType( Application application, String strDemandType, Class<T> demandClass )
    {
        return DemandHome.getDemandsListByApplicationAndType( application.getId(), strDemandType, demandClass );
    }
    
    public static String getDemandAsString( Demand demand )
    {
        try
        {
            return _mapper.writeValueAsString( demand );
        }
        catch ( JsonProcessingException e )
        {
            AppLogService.error( "Unable to convert demand obj to JSON", e);
        }
        return null;    
    }
    
    /**
     * Get the demand filter from the Http request
     * @param request
     * @return the demand filter
     */
    public static DemandFilter computeDemandFilter ( HttpServletRequest request )
    {
        String strEnvironmentPrefix = request.getParameter( PARAMETER_ENVIRONMENT_PREFIX );
        String strIdDemandType = request.getParameter( PARAMETER_ID_DEMAND_TYPE );
        String strIsClosed = request.getParameter( PARAMETER_IS_CLOSED );
        String strApplicationId = request.getParameter( PARAMETER_ID_APPLICATION );
        
        DemandFilter filter = new DemandFilter();
        if ( strEnvironmentPrefix != null && !strEnvironmentPrefix.equals( "-1" ) )
        {
            filter.setEnvironmentPrefix( strEnvironmentPrefix );
            filter.setHasEnvironmentPrefix(true );
        }
        if ( strIdDemandType != null && !strIdDemandType.equals( "-1" ))
        {
            filter.setIdDemandType( strIdDemandType );
            filter.setHasIdDemandType( true );
        }
        if ( strIsClosed != null && !strIsClosed.equals( "-1" ) )
        {
            if ( strIsClosed.equals( "true" ) )
            {
                filter.setIsClosed( true );
                filter.setHasIsClosed( true );
            }
            else if( strIsClosed.equals( "false" ) )
            {
                filter.setIsClosed( false );
                filter.setHasIsClosed( true );
            }
        }
            
        if ( strApplicationId != null  && !strApplicationId.equals( "-1" ))
        {
            filter.setIdApplication( Integer.parseInt( strApplicationId ) );
            filter.setHasIdApplication( true );
        }
        
        return filter;
    }
     
}


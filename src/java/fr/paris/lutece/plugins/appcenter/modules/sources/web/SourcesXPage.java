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

package fr.paris.lutece.plugins.appcenter.modules.sources.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import fr.paris.lutece.plugins.appcenter.business.Application;
import fr.paris.lutece.plugins.appcenter.business.Config;
import fr.paris.lutece.plugins.appcenter.business.Demand;
import fr.paris.lutece.plugins.appcenter.business.DemandHome;
import fr.paris.lutece.plugins.appcenter.modules.sources.business.SourcesData;
import fr.paris.lutece.plugins.appcenter.service.ApplicationService;
import fr.paris.lutece.plugins.appcenter.service.ConfigsData;
import fr.paris.lutece.plugins.appcenter.service.DemandService;
import fr.paris.lutece.plugins.appcenter.service.DemandTypeService;
import fr.paris.lutece.plugins.appcenter.web.AppCenterXPage;
import fr.paris.lutece.plugins.appcenter.web.Constants;
import fr.paris.lutece.plugins.workflowcore.business.state.State;
import fr.paris.lutece.portal.service.security.UserNotSignedException;
import fr.paris.lutece.portal.service.workflow.WorkflowService;
import fr.paris.lutece.portal.util.mvc.commons.annotations.Action;
import fr.paris.lutece.portal.util.mvc.commons.annotations.View;
import fr.paris.lutece.portal.util.mvc.xpage.annotations.Controller;
import fr.paris.lutece.portal.web.xpages.XPage;
import java.util.ArrayList;

/**
 * SourcesXPage
 */
@Controller( xpageName = "sources", pageTitleI18nKey = "appcenter.xpage.sources.pageTitle", pagePathI18nKey = "appcenter.xpage.sources.pagePathLabel" )
public class SourcesXPage extends AppCenterXPage
{
    // Templates
    private static final String TEMPLATE_MANAGE_SOURCES = "/skin/plugins/appcenter/modules/sources/manage_sources.html";

    private static final String PARAMETER_SITE_REPOSITORY = "site_repository";
    private static final String PARAMETER_SVN_USERNAMES = "svn_usernames";
    private static final String PARAMETER_SVN_EMAILS = "svn_emails";
    
    private static final String MESSAGE_KEY_SVN_USERNAME = "appcenter.manage_sources.labelSvnAccessDemandUserName.label";
    private static final String MESSAGE_KEY_SVN_EMAIL = "appcenter.manage_sources.labelSvnAccessDemandUserEmail.label";

    private static final String VIEW_MANAGE_SOURCES = "sources";
    private static final String ACTION_ADD_SITE_REPOSITORY = "addSiteRepository";
    private static final String ACTION_ADD_ACCESS_DEMAND = "addAccessDemand";

    public static final String WORKFLOW_RESOURCE_TYPE = "DEMANDCENTER_DEMAND_SOURCE";
    public static final String DEMAND_TYPE = "sources";

    @View( value = VIEW_MANAGE_SOURCES, defaultView = true )
    public XPage getManageApplications( HttpServletRequest request )  throws UserNotSignedException
    {
       
    	Application application = getApplication(request);
        SourcesData dataSubset = ApplicationService.loadApplicationDataSubset( application, SourcesData.DATA_SUBSET_NAME, SourcesData.class );

        Map<String, Object> model = getModel( );
        model.put( Constants.MARK_APPLICATION, application );
        model.put( Constants.MARK_DATA, dataSubset );
        List<Demand> listDemand = DemandHome.getDemandsListByApplicationAndType( application.getId(), DEMAND_TYPE );
        model.put( Constants.MARK_DEMANDS, listDemand );
        int nIdWorkflow = DemandTypeService.getIdWorkflow( DEMAND_TYPE );
        Map<String, Object> mapStates = new HashMap<>();
        Map<String, Object> mapHistories = new HashMap<>();
        for (Demand demand: listDemand) {
            State state = WorkflowService.getInstance( ).getState( demand.getId( ), WORKFLOW_RESOURCE_TYPE, nIdWorkflow, -1 );
            mapStates.put( Integer.toString( demand.getId() ), state );

            String strHistoryHtml = WorkflowService.getInstance( ).getDisplayDocumentHistory(
                    demand.getId( ), WORKFLOW_RESOURCE_TYPE, nIdWorkflow, request, request.getLocale( )
            );
            mapHistories.put( Integer.toString( demand.getId( ) ), strHistoryHtml );
        }
        model.put( Constants.MARK_DEMANDS_STATES, mapStates );
        model.put( Constants.MARK_DEMANDS_HISTORIES, mapHistories );

        return getXPage( TEMPLATE_MANAGE_SOURCES, request.getLocale( ), model );
    }

    @Action( ACTION_ADD_SITE_REPOSITORY )
    public XPage doAddSiteRepository( HttpServletRequest request )  throws UserNotSignedException
    {
        String strSiteDirectory = request.getParameter( PARAMETER_SITE_REPOSITORY );
        Application application = getApplication(request);
        SourcesData dataSubset = ApplicationService.loadApplicationDataSubset( application, SourcesData.DATA_SUBSET_NAME, SourcesData.class );
        if ( dataSubset == null )
        {
            dataSubset = new SourcesData( );
        }
        dataSubset.setSiteRepository( strSiteDirectory );
        ApplicationService.saveApplicationData( application, dataSubset );

        return redirect( request, VIEW_MANAGE_SOURCES, Constants.PARAMETER_ID_APPLICATION, application.getId() );
    }


    @Action( ACTION_ADD_ACCESS_DEMAND )
    public XPage doAddAccessDemand( HttpServletRequest request )  throws UserNotSignedException
    {
        int nId = Integer.parseInt( request.getParameter( Constants.PARAMETER_ID_APPLICATION ) );
        Application application = getApplication(request);
        Demand demand = new Demand( );
        demand.setIdDemandType( DEMAND_TYPE );
        demand.setDemandType( DEMAND_TYPE );
        demand.setIdApplication( application.getId( ) );
        DemandHome.create( demand );
        
        String strSVNUserNames = request.getParameter( PARAMETER_SVN_USERNAMES );
        String strSVNUserEmails = request.getParameter( PARAMETER_SVN_EMAILS );
        
        //Save the configs
        List<Config> listConfig = new ArrayList<>();
        listConfig.add( new Config( MESSAGE_KEY_SVN_USERNAME, strSVNUserNames ) );
        listConfig.add( new Config( MESSAGE_KEY_SVN_EMAIL, strSVNUserEmails ) );
        ConfigsData configDatas = new ConfigsData();
        configDatas.setListConfigs( listConfig );
        DemandService.saveDemandData( demand, configDatas );
        
        //Run the workflow
        int nIdResource = application.getId( );
        int nIdWorkflow = DemandTypeService.getIdWorkflow( demand.getDemandType() );
        WorkflowService.getInstance( ).getState( nIdResource, WORKFLOW_RESOURCE_TYPE, nIdWorkflow, -1 );
        WorkflowService.getInstance( ).executeActionAutomatic( nIdResource, WORKFLOW_RESOURCE_TYPE, nIdWorkflow, -1 );

        return redirect( request, VIEW_MANAGE_SOURCES, Constants.PARAMETER_ID_APPLICATION, nId );
    }
}

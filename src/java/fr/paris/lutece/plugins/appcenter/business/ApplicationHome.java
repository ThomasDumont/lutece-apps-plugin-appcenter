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
package fr.paris.lutece.plugins.appcenter.business;

import fr.paris.lutece.plugins.appcenter.service.RoleService;
import fr.paris.lutece.portal.service.plugin.Plugin;
import fr.paris.lutece.portal.service.plugin.PluginService;
import fr.paris.lutece.portal.service.spring.SpringContextService;
import fr.paris.lutece.util.ReferenceList;

import java.util.List;

/**
 * This class provides instances management methods (create, find, ...) for Application objects
 */
public final class ApplicationHome
{
    // Static variable pointed at the DAO instance
    private static IApplicationDAO _dao = SpringContextService.getBean( "appcenter.applicationDAO" );
    private static Plugin _plugin = PluginService.getPlugin( "appcenter" );

    /**
     * Private constructor - this class need not be instantiated
     */
    private ApplicationHome( )
    {
    }

    /**
     * Create an instance of the application class
     * 
     * @param application
     *            The instance of the Application which contains the informations to store
     * @return The instance of application which has been created with its primary key.
     */
    public static Application create( Application application )
    {
        _dao.insert( application, _plugin );

        return application;
    }

    /**
     * Update of the application which is specified in parameter
     * 
     * @param application
     *            The instance of the Application which contains the data to store
     * @return The instance of the application which has been updated
     */
    public static Application update( Application application )
    {
        _dao.store( application, _plugin );

        return application;
    }

    /**
     * Update of the application data
     * 
     * @param nApplicationId
     *            The application ID
     * 
     *            The instance of the Application which contains the data to store
     * @param strData
     *            The data
     */
    public static void updateData( int nApplicationId, String strData )
    {
        _dao.storeData( nApplicationId, strData, _plugin );

    }

    /**
     * Remove the application whose identifier is specified in parameter
     * 
     * @param nKey
     *            The application Id
     */
    public static void remove( int nKey )
    {
        _dao.delete( nKey, _plugin );
    }

    /**
     * Returns an instance of a application whose identifier is specified in parameter
     * 
     * @param nKey
     *            The application primary key
     * @return an instance of Application
     */
    public static Application findByPrimaryKey( int nKey )
    {
        Application application = _dao.load( nKey, _plugin );
        if( application != null )
        {
            application.setAuthorizations( UserApplicationHome.findByApplication( application.getId() ));
        }
        return application;
    }

    /**
     * Load the data of all the application objects and returns them as a list
     * 
     * @return the list which contains the data of all the application objects
     */
    public static List<Application> getApplicationsList( )
    {
        return _dao.selectApplicationsList( _plugin );
    }

    /**
     * Load the data of all the application objects and returns them as a referenceList
     * 
     * @return the referenceList which contains the data of all the application objects
     */
    public static ReferenceList getApplicationsReferenceList( )
    {
        return _dao.selectApplicationsReferenceList( _plugin );
    }

    /**
     * Get authorized app for a given user
     * 
     * @param strUserId
     *            The user ID
     * @return The list of apps
     */
    public static List<AuthorizedApp> getApplicationsByUser( String strUserId )
    {
        return _dao.selectByUserId( strUserId, _plugin );
    }

    /**
     * Checks if an application is authorized for a given user
     * 
     * @param nApplicationId
     *            The application Id
     * @param strUserId
     *            The user Id
     * @return true if authorized
     */
    public static boolean isAuthorized( int nApplicationId, String strUserId )
    {
        int nRole =  _dao.getUserRole( nApplicationId, strUserId, RoleService.ROLE_NONE, _plugin );
        return nRole != RoleService.ROLE_NONE;
    }

    /**
     * Get the role of the user for a given application
     * 
     * @param nApplicationId
     *            The application Id
     * @param strUserId
     *            The user Id
     * @return The role
     */
    public static int getUserRole( int nApplicationId, String strUserId )
    {
        return _dao.getUserRole( nApplicationId, strUserId, RoleService.ROLE_NONE, _plugin );
    }

}

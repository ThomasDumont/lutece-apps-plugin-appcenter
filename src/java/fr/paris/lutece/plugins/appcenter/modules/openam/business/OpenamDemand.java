package fr.paris.lutece.plugins.appcenter.modules.openam.business;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import fr.paris.lutece.plugins.appcenter.business.Demand;
import fr.paris.lutece.portal.service.template.AppTemplateService;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * 
 * OpenamDemand
 *
 */
public class OpenamDemand extends Demand
{

    public static final String ID_DEMAND_TYPE = "openam";
    public static final String DEMAND_TYPE = "openam";

    private static final String TEMPLATE_SOURCES_DEMAND_INFOS = "skin/plugins/appcenter/modules/openam/openam_agents_demand_infos.html";

    @NotEmpty( message = "#i18n{module.appcenter.openam.validation.openamagent.webapp.notEmpty}" )
    @Size( max = 50, message = "#i18n{module.appcenter.openam.validation.openamagent.webapp.size}" )
    private String _strWebAppName;
    @NotEmpty( message = "#i18n{module.appcenter.openam.validation.openamagent.publicurl.notEmpty}" )
    @Size( max = 50, message = "#i18n{module.appcenter.openam.validation.openamagent.publicurl.size}" )
    private String _strPublicUrl;
    private boolean _bG98SettingNeeded;

    public String getWebappName( )
    {
        return _strWebAppName;
    }

    public void setWebappName( String strWebAppName )
    {
        _strWebAppName = strWebAppName;
    }

    public String getPublicUrl( )
    {
        return _strPublicUrl;
    }

    public void setPublicUrl( String strPublicUrl )
    {
        _strPublicUrl = strPublicUrl;
    }

    /**
     * Returns a boolean describing whether a G98 setting is needed or not
     *
     * @return True if a G98 setting is needed
     */
    public boolean getG98SettingNeeded( )
    {
        return _bG98SettingNeeded;
    }

    /**
     * Sets a boolean describing whether a G98 setting is needed or not
     *
     * @param bG98SettingNeeded
     *            True if a G98 setting is needed
     */
    public void setG98SettingNeeded( boolean bG98SettingNeeded )
    {
        _bG98SettingNeeded = bG98SettingNeeded;
    }

    @Override
    public String getComplementaryInfos( )
    {
        Map<String, Object> model = new HashMap<String, Object>( );
        model.put( MARK_DEMAND, this );
        return AppTemplateService.getTemplate( TEMPLATE_SOURCES_DEMAND_INFOS, Locale.FRENCH, model ).getHtml( );
    }

    /**
     * Get the demand type id
     * 
     * @return the demand type id
     */
    @JsonIgnore
    @Override
    public String getIdDemandType( )
    {
        return ID_DEMAND_TYPE;
    }

    /**
     * Get the demand type id
     * 
     * @return the demand type id
     */
    @JsonIgnore
    @Override
    public String getDemandType( )
    {
        return DEMAND_TYPE;
    }

    @JsonIgnore
    @Override
    public boolean isDependingOfEnvironment()
    {
        return true;
    }

}

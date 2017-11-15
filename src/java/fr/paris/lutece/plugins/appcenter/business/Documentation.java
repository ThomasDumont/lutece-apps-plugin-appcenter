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



/**
 * This is the business class for the object Documentation
 */ 
public class Documentation
{
        // Variables declarations 
        private int _nId;
        private int _nIdDemandType;
        private String _strLabel;
        private String _strUrl;
        private String _strCategory;
    
    
       /**
        * Returns the Id
        * @return The Id
        */ 
        public int getId()
        {
            return _nId;
        }
    
       /**
        * Sets the Id
        * @param nId The Id
        */ 
        public void setId( int nId )
        {
            _nId = nId;
        }
    
       /**
        * Returns the IdDemandType
        * @return The IdDemandType
        */ 
        public int getIdDemandType()
        {
            return _nIdDemandType;
        }
    
       /**
        * Sets the IdDemandType
        * @param nIdDemandType The IdDemandType
        */ 
        public void setIdDemandType( int nIdDemandType )
        {
            _nIdDemandType = nIdDemandType;
        }
    
       /**
        * Returns the Label
        * @return The Label
        */ 
        public String getLabel()
        {
            return _strLabel;
        }
    
       /**
        * Sets the Label
        * @param strLabel The Label
        */ 
        public void setLabel( String strLabel )
        {
            _strLabel = strLabel;
        }
    
       /**
        * Returns the Url
        * @return The Url
        */ 
        public String getUrl()
        {
            return _strUrl;
        }
    
       /**
        * Sets the Url
        * @param strUrl The Url
        */ 
        public void setUrl( String strUrl )
        {
            _strUrl = strUrl;
        }
    
       /**
        * Returns the Category
        * @return The Category
        */ 
        public String getCategory()
        {
            return _strCategory;
        }
    
       /**
        * Sets the Category
        * @param strCategory The Category
        */ 
        public void setCategory( String strCategory )
        {
            _strCategory = strCategory;
        }
 }

/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package mf.org.apache.html.dom;

import mf.org.w3c.dom.html.HTMLLIElement;

/**
 * @xerces.internal
 * @version $Revision: 1029415 $ $Date: 2010-10-31 13:02:22 -0400 (Sun, 31 Oct 2010) $
 * @author <a href="mailto:arkin@exoffice.com">Assaf Arkin</a>
 * @see HTMLLIElement
 * @see mf.org.apache.xerces.dom.ElementImpl
 */
public class HTMLLIElementImpl
    extends HTMLElementImpl
	    implements HTMLLIElement
{

    private static final long serialVersionUID = -8987309345926701831L;

    public String getType()
    {
        return getAttribute( "type" );
    }
    
    
    public void setType( String type )
    {
        setAttribute( "type", type );
    }
        

    public int getValue()
    {
        return getInteger( getAttribute( "value" ) );
    }

    
    public void setValue( int value )
    {
        setAttribute( "value", String.valueOf( value ) );
    }

    
    /**
     * Constructor requires owner document.
     * 
     * @param owner The owner HTML document
     */
    public HTMLLIElementImpl( HTMLDocumentImpl owner, String name )
    {
        super( owner, name );
    }


}


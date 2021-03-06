/*
 * This file is protected by Copyright. Please refer to the COPYRIGHT file
 * distributed with this source distribution.
 *
 * This file is part of REDHAWK __REDHAWK_PROJECT__.
 *
 * REDHAWK __REDHAWK_PROJECT__ is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or (at your
 * option) any later version.
 *
 * REDHAWK __REDHAWK_PROJECT__ is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see http://www.gnu.org/licenses/.
 */
package redhawk.driver.base;

import java.util.Map;

import redhawk.driver.logging.RedhawkLogging;
import redhawk.driver.properties.RedhawkProperty;

public interface QueryableResource extends RedhawkLogging{
	/**
	 * Get all the properties for a resource. 
	 * @return
	 */
    public Map<String, RedhawkProperty> getProperties();
    
    /**
     * Get specific properties for a resource. 
     * @param propertyNames
     * @return
     */
    public <T> T getProperty(String ... propertyNames);
    
    /**
     * Helper method for setting a property. 
     * 
     * @param propertyName
     * 	Name of the value
     * @param propertyValue
     * 	Value representing the property. 
  	 *  TODO: Add table for simple/simpleseq/struct/structsequence
     */
    public void setProperty(String propertyName, Object propertyValue) throws Exception;
    
}

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
package redhawk.driver.connectionmanager;

import java.util.List;

import CF.ConnectionManager;
import redhawk.driver.base.impl.RedhawkEndpoint;
import redhawk.driver.connectionmanager.impl.ConnectionInfo;
import redhawk.driver.exceptions.ConnectionException;

public interface RedhawkConnectionManager {
	//TODO: Not just ports it could be any endpoint
	void connect(RedhawkEndpoint outputPort, RedhawkEndpoint inputPort, String requestId, String connectionId) throws ConnectionException;
	
	void disconnect(String connectionId);
	
	List<ConnectionInfo> getConnections();
	
	ConnectionManager getCorbaObj();
}
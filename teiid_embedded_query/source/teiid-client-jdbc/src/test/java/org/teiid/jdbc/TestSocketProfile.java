/*
 * JBoss, Home of Professional Open Source.
 * See the COPYRIGHT.txt file distributed with this work for information
 * regarding copyright ownership.  Some portions may be licensed
 * to Red Hat, Inc. under one or more contributor license agreements.
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
 * 02110-1301 USA.
 */

package org.teiid.jdbc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.Properties;

import org.junit.Test;

import com.metamatrix.common.api.MMURL;
import com.metamatrix.jdbc.BaseDataSource;
import com.metamatrix.jdbc.api.ExecutionProperties;

public class TestSocketProfile {
    public String localhost = "localhost"; //$NON-NLS-1$
    
    /** Valid format of urls*/
    @Test public void testAcceptsURL1()  throws Exception   {
        assertTrue(SocketProfile.acceptsURL("jdbc:teiid:jvdb@mm://localhost:1234")); //$NON-NLS-1$
        assertTrue(SocketProfile.acceptsURL("jdbc:metamatrix:jvdb@mm://localhost:1234")); //$NON-NLS-1$
        assertTrue(SocketProfile.acceptsURL("jdbc:teiid:vdb@mm://localhost:1234;version=x")); //$NON-NLS-1$
        assertTrue(SocketProfile.acceptsURL("jdbc:teiid:vdb@mm://localhost:1234")); //$NON-NLS-1$
        assertTrue(SocketProfile.acceptsURL("jdbc:teiid:vdb@mm://localhost:1234,localhost2:12342,localhost3:12343")); //$NON-NLS-1$       
        assertTrue(SocketProfile.acceptsURL("jdbc:teiid:vdb@mm://localhost:1234;logFile=D:\\metamatrix\\work\\DQP\\log\\jdbcLogFile.log")); //$NON-NLS-1$
        assertTrue(SocketProfile.acceptsURL("jdbc:teiid:vdb@mm://localhost:1234,localhost2:12342,localhost3:12343;logFile=D:\\metamatrix\\work\\DQP\\log\\jdbcLogFile.log")); //$NON-NLS-1$
        assertTrue(SocketProfile.acceptsURL("jdbc:teiid:vdb@mms://localhost:1234;logLevel=1;logFile=D:\\metamatrix\\work\\DQP\\log\\jdbcLogFile.log")); //$NON-NLS-1$
        assertTrue(!SocketProfile.acceptsURL("jdbc:teiid:@mm://localhost:1234;logLevel=2;logFile=D:\\metamatrix\\work\\DQP\\log\\jdbcLogFile.log")); //$NON-NLS-1$
        assertTrue(SocketProfile.acceptsURL("jdbc:teiid:vdb@mm://localhost:1234;logLevel=2;logFile=D:\\metamatrix\\work\\DQP\\log\\jdbcLogFile.log;txnAutoWrap=OFF;paritalResultsMode=true")); //$NON-NLS-1$
        assertTrue(SocketProfile.acceptsURL("jdbc:teiid:jvdb@mms://localhost:1234")); //$NON-NLS-1$
        assertTrue(SocketProfile.acceptsURL("jdbc:teiid:vdb@mm://localhost:1234;version=x")); //$NON-NLS-1$
        assertTrue(SocketProfile.acceptsURL("jdbc:teiid:vdb@mm://localhost:1234,localhost2:12342,localhost3:12343")); //$NON-NLS-1$       
        assertTrue(SocketProfile.acceptsURL("jdbc:teiid:vdb@mms://localhost:1234,localhost2:12342,localhost3:12343;logFile=D:\\metamatrix\\work\\DQP\\log\\jdbcLogFile.log")); //$NON-NLS-1$
        assertTrue(SocketProfile.acceptsURL("jdbc:teiid:vdb@mms://localhost:1234;logLevel=2;logFile=D:\\metamatrix\\work\\DQP\\log\\jdbcLogFile.log;txnAutoWrap=OFF;paritalResultsMode=true")); //$NON-NLS-1$
        assertTrue(SocketProfile.acceptsURL("jdbc:teiid:vdb@mm://127.0.0.1:1234;logLevel=2")); //$NON-NLS-1$
        assertTrue(SocketProfile.acceptsURL("jdbc:teiid:vdb@mms://127.0.0.1:1234")); //$NON-NLS-1$
        assertTrue(SocketProfile.acceptsURL("jdbc:teiid:vdb@mm://127.0.0.1:1234,localhost.mydomain.com:63636;logLevel=2")); //$NON-NLS-1$
        assertTrue(SocketProfile.acceptsURL("jdbc:teiid:vdb@mm://my-host.mydomain.com:53535,127.0.0.1:1234")); //$NON-NLS-1$
        assertTrue(SocketProfile.acceptsURL("jdbc:teiid:vdb@mm://123.123.123.123:53535,127.0.0.1:1234")); //$NON-NLS-1$
        
        assertTrue(!SocketProfile.acceptsURL("jdbc:metamatrix:jvdb@localhost:1234")); //$NON-NLS-1$
        assertTrue(!SocketProfile.acceptsURL("jdbc:teiid:jvdb@localhost:1234")); //$NON-NLS-1$

        //DQP type
        assertTrue(!SocketProfile.acceptsURL("jdbc:teiid:jvdb@c:/dqp.properties;version=1")); //$NON-NLS-1$
        assertTrue(!SocketProfile.acceptsURL("jdbc:teiid:jvdb@/foo/dqp.properties;version=1")); //$NON-NLS-1$
        assertTrue(!SocketProfile.acceptsURL("jdbc:teiid:jvdb@../foo/dqp.properties;version=1")); //$NON-NLS-1$
        
        assertTrue(!SocketProfile.acceptsURL("jdbc:teiid:jvdb@mm://localhost:port")); //$NON-NLS-1$
        assertTrue(!SocketProfile.acceptsURL("jdbc:teiid:vdb@localhost:port;version=x")); //$NON-NLS-1$
        assertTrue(!SocketProfile.acceptsURL("jdbc:teiid:@localhost:1234")); //$NON-NLS-1$
        assertTrue(!SocketProfile.acceptsURL("jdbc:teiid:@localhost:1234,localhost2:12342,localhost3:12343")); //$NON-NLS-1$       
        assertTrue(!SocketProfile.acceptsURL("jdbc:teiid:@localhost:1234;logFile=D:\\metamatrix\\work\\DQP\\log\\jdbcLogFile.log")); //$NON-NLS-1$
        assertTrue(!SocketProfile.acceptsURL("jdbc:teiid:@localhost:1234,localhost2:12342,localhost3:12343;logFile=D:\\metamatrix\\work\\DQP\\log\\jdbcLogFile.log")); //$NON-NLS-1$
        assertTrue(!SocketProfile.acceptsURL("jdbc:teiid:@localhost:1234;logLevel=1;logFile=D:\\metamatrix\\work\\DQP\\log\\jdbcLogFile.log")); //$NON-NLS-1$
        assertTrue(!SocketProfile.acceptsURL("jdbc:teiid:@localhost:1234;logLevel=2;logFile=D:\\metamatrix\\work\\DQP\\log\\jdbcLogFile.log")); //$NON-NLS-1$
        assertTrue(!SocketProfile.acceptsURL("jdbc:teiid:@localhost:1234;logLevel=2;logFile=D:\\metamatrix\\work\\DQP\\log\\jdbcLogFile.log;txnAutoWrap=OFF;paritalResultsMode=true")); //$NON-NLS-1$
        assertTrue(!SocketProfile.acceptsURL("jdbc:teiid:@localhost:1234;stickyConnections=false;socketsPerVM=4")); //$NON-NLS-1$
        assertTrue(!SocketProfile.acceptsURL("jdbc:teiid:vdb@mm://my_host.mydomain.com:53535,127.0.0.1:1234")); //$NON-NLS-1$        
    }

    /** Invalid format of urls*/
    @Test public void testAcceptsURL2() throws Exception    {
        assertTrue(!SocketProfile.acceptsURL("jdbc:matamatrix:test")); //$NON-NLS-1$
        assertTrue(!SocketProfile.acceptsURL("metamatrix:test")); //$NON-NLS-1$
        assertTrue(!SocketProfile.acceptsURL("jdbc&matamatrix:test")); //$NON-NLS-1$
        assertTrue(!SocketProfile.acceptsURL("jdbc;metamatrix:test")); //$NON-NLS-1$
    }   

    @Test public void testParseURL() throws SQLException{
        Properties p = new Properties();
        SocketProfile.parseURL("jdbc:teiid:BQT@mm://slwxp157:1234", p); //$NON-NLS-1$
        assertTrue(p.getProperty(BaseDataSource.VDB_NAME).equals("BQT")); //$NON-NLS-1$
        assertTrue(p.getProperty(MMURL.CONNECTION.SERVER_URL).equals("mm://slwxp157:1234")); //$NON-NLS-1$
        assertEquals(3, p.size());        
    }

    @Test public void testParseURL2() throws SQLException {
        Properties p = new Properties();       
        SocketProfile.parseURL("jdbc:teiid:BQT@mms://slwxp157:1234;version=3", p); //$NON-NLS-1$
        assertTrue(p.getProperty(BaseDataSource.VDB_NAME).equals("BQT")); //$NON-NLS-1$
        assertTrue(p.getProperty(BaseDataSource.VDB_VERSION).equals("3")); //$NON-NLS-1$
        assertTrue(p.getProperty(MMURL.CONNECTION.SERVER_URL).equals("mms://slwxp157:1234")); //$NON-NLS-1$
        assertTrue(p.getProperty(BaseDataSource.VERSION).equals("3")); //$NON-NLS-1$
        assertTrue(p.getProperty(BaseDataSource.APP_NAME).equals(BaseDataSource.DEFAULT_APP_NAME));
        assertEquals(5, p.size());
    }
    
    @Test public void testParseURL3() throws SQLException{
        Properties p = new Properties();
        SocketProfile.parseURL("jdbc:teiid:BQT@mm://slwxp157:1234,slntmm01:43401,sluxmm09:43302;version=4;txnAutoWrap=ON;partialResultsMode=YES;ApplicationName=Client", p); //$NON-NLS-1$
        assertTrue(p.getProperty(BaseDataSource.VDB_NAME).equals("BQT")); //$NON-NLS-1$
        assertTrue(p.getProperty(BaseDataSource.VDB_VERSION).equals("4"));         //$NON-NLS-1$
        assertTrue(p.getProperty(ExecutionProperties.PROP_TXN_AUTO_WRAP).equals("ON")); //$NON-NLS-1$
        assertTrue(p.getProperty(ExecutionProperties.PROP_PARTIAL_RESULTS_MODE).equals("YES")); //$NON-NLS-1$
        assertTrue(p.getProperty(MMURL.CONNECTION.SERVER_URL).equals("mm://slwxp157:1234,slntmm01:43401,sluxmm09:43302")); //$NON-NLS-1$
        assertTrue(p.getProperty(BaseDataSource.VERSION).equals("4")); //$NON-NLS-1$
        assertTrue(p.getProperty(BaseDataSource.APP_NAME).equals("Client")); //$NON-NLS-1$
        assertEquals(7, p.size());        
    }    
}

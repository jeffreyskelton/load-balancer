/*
 * TeleStax, Open Source Cloud Communications
 * Copyright 2011-2013, Telestax Inc and individual contributors
 * by the @authors tag.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.mobicents.tools.telestaxproxy.dao.mappers;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.mobicents.tools.telestaxproxy.sip.balancer.entities.RestcommInstance;

/**
 * This is the mapper for Restcomm instances
 * 
 * @author <a href="mailto:gvagenas@gmail.com">gvagenas</a>
 *
 */
public abstract interface RestcommInstanceMapper {

    public static final String INSERT = "INSERT INTO restcomm_instances (id, udpInterface, tcpInterface, tlsInterface, wsInterface, dateCreated) "
            + "VALUES (#{id}, #{udpInterface}, #{tcpInterface}, #{tlsInterface}, #{wsInterface},#{dateCreated})";
    public static final String SELECT_BY_ID = "SELECT * FROM restcomm_instances WHERE id=#{id}";
    public static final String UPDATE = "UPDATE restcomm_instances SET udpInterface=#{udpInterface}, tcpInterface=#{tcpInterface}, tlsInterface=#{tlsInterface},"
            + " wsInterface=#{wsInterface}, dateCreated=#{dateCreated}  WHERE id=#{id}";

    @Insert(INSERT)
    public abstract void addRestcommInstance(RestcommInstance restcommInstance);
    
    @Select(SELECT_BY_ID)
    public abstract RestcommInstance getInstanceById(String id);

    @Update(UPDATE)
    public abstract void updateRestcommInstance(RestcommInstance restcommInstance);
}

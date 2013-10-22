/*
 * <copyright>
 *  
 *  Copyright 2001-2004 Mobile Intelligence Corp
 *  under sponsorship of the Defense Advanced Research Projects
 *  Agency (DARPA).
 * 
 *  You can redistribute this software and/or modify it under the
 *  terms of the Cougaar Open Source License as published on the
 *  Cougaar Open Source Website (www.cougaar.org).
 * 
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 *  "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 *  LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 *  A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 *  OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 *  SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 *  LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 *  DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 *  THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 *  (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 *  OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *  
 * </copyright>
 */

package org.cougaar.community.manager;

import java.util.Set;
import javax.naming.directory.ModificationItem;

import org.cougaar.core.mts.MessageAddress;

import org.cougaar.core.service.community.CommunityResponse;
import org.cougaar.core.service.community.CommunityResponseListener;
import org.cougaar.community.CommunityServiceConstants;
import org.cougaar.core.service.community.Entity;
import org.cougaar.core.util.UniqueObject;

/**
 * Blackboard Relay used by CommunityService to send request to remote
 * Community Manager.  This interface should only be used by Community
 * Service implementations, it is not intended for use by clients.
 **/
public interface Request extends UniqueObject, CommunityServiceConstants {

  public String getCommunityName();

  public void setRequestType(int reqType);
  public int getRequestType();
  public String getRequestTypeAsString(int type);
  public MessageAddress getSource();

  public void addCommunityResponseListener(CommunityResponseListener crl);
  public Set getCommunityResponseListeners();

  public void setEntity(Entity entity);
  public Entity getEntity();

  public void setAttributeModifications(ModificationItem[] mods);
  public ModificationItem[] getAttributeModifications();

  public void setResponse(CommunityResponse resp);
  public Object getResponse();

}
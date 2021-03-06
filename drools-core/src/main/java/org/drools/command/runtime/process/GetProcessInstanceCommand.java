/*
 * Copyright 2010 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.drools.command.runtime.process;

import org.drools.command.impl.GenericCommand;
import org.drools.command.impl.KnowledgeCommandContext;
import org.kie.command.Context;
import org.kie.runtime.KieSession;
import org.kie.runtime.process.ProcessInstance;

public class GetProcessInstanceCommand implements GenericCommand<ProcessInstance> {

    private Long processInstanceId;
    private boolean readOnly = false;

    public GetProcessInstanceCommand() {}

    public GetProcessInstanceCommand(Long processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public Long getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(Long processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public boolean isReadOnly() {
		return readOnly;
	}

	public void setReadOnly(boolean readOnly) {
		this.readOnly = readOnly;
	}

	public ProcessInstance execute(Context context) {
        KieSession ksession = ((KnowledgeCommandContext) context).getKieSession();
        if (processInstanceId == null) {
            return null;
        }
        return ksession.getProcessInstance(processInstanceId, readOnly);
    }

    public String toString() {
        return "session.getProcessInstance(" + processInstanceId + ");";
    }

}

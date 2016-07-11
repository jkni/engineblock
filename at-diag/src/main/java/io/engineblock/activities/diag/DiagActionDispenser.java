/*
*   Copyright 2016 jshook
*   Licensed under the Apache License, Version 2.0 (the "License");
*   you may not use this file except in compliance with the License.
*   You may obtain a copy of the License at
*
*       http://www.apache.org/licenses/LICENSE-2.0
*
*   Unless required by applicable law or agreed to in writing, software
*   distributed under the License is distributed on an "AS IS" BASIS,
*   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
*   See the License for the specific language governing permissions and
*   limitations under the License.
*/
package io.engineblock.activities.diag;

import io.engineblock.activityapi.Action;
import io.engineblock.activityapi.ActionDispenser;
import io.engineblock.activityapi.ActivityDef;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

public class DiagActionDispenser implements ActionDispenser {

    private final static Logger logger = getLogger(DiagActionDispenser.class);
    private ActivityDef activityDef;

    public DiagActionDispenser(ActivityDef activityDef) {
        this.activityDef = activityDef;
    }

    @Override
    public Action getAction(int slot) {
        logger.debug("creating new DiagAction instance for slot=" + slot +", activityDef=" + activityDef);
        return new DiagAction(slot, activityDef);
    }
}

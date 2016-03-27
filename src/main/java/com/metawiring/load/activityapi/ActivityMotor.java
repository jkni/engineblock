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

package com.metawiring.load.activityapi;

import com.metawiring.load.cycler.MotorController;

/**
 * The core threading harness within an activity.
 */
public interface ActivityMotor extends Runnable {

    /**
     * Set the input on this motor. It will be read from each cycle before applying the action.
     *
     * @param input an instance of ActivityInput
     * @return this ActivityMotor, for method chaining
     */
    ActivityMotor setInput(Input input);

    /**
     * Set the action on this motor. It will be applied to each input.
     *
     * @param action an instance of activityAction
     * @return this ActivityMotor, for method chaining
     */
    ActivityMotor setAction(Action action);

    /**
     * @return the motor controller instance which is used to signal motor state.
     */
    MotorController getMotorController();

    /**
     * @return true if the motor knows that is running in an active thread, false otherwise.
     */
    default boolean hasStarted() {
        return (getMotorController().getRunState() == MotorController.RunState.Started);
    }

    /**
     * get the slotId which this motor is assigned to within the activity instance.
     * @return long slot id
     */
    long getSlotId();
}
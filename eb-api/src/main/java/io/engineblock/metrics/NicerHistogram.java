/*
 *
 *    Copyright 2016 jshook
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 * /
 */

package io.engineblock.metrics;

import com.codahale.metrics.Histogram;
import org.mpierce.metrics.reservoir.hdrhistogram.HdrHistogramResetOnSnapshotReservoir;

public class NicerHistogram extends Histogram {

    public NicerHistogram(HdrHistogramResetOnSnapshotReservoir hdrHistogramResetOnSnapshotReservoir) {
        super(hdrHistogramResetOnSnapshotReservoir);
    }

    @Override
    public ConvenientSnapshot getSnapshot() {
        return new ConvenientSnapshot(super.getSnapshot());
    }
}
/*
    This file is part of Project MAXS.

    MAXS and its modules is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    MAXS is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with MAXS.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.projectmaxs.module.filewrite;

import org.projectmaxs.shared.global.Message;
import org.projectmaxs.shared.global.util.Log;
import org.projectmaxs.shared.mainmodule.Command;
import org.projectmaxs.shared.mainmodule.ModuleInformation;
import org.projectmaxs.shared.module.MAXSModuleIntentService;

import android.content.Context;

public class ModuleService extends MAXSModuleIntentService {
	private final static Log LOG = Log.getLog();

	public ModuleService() {
		super(LOG, "maxs-module-filewrite");
	}

	// @formatter:off
	public static final ModuleInformation sMODULE_INFORMATION = new ModuleInformation(
			"org.projectmaxs.module.filewrite",      // Package of the Module
			"filewrite",                             // Name of the Module (if omitted, last substring after '.' is used)
			new ModuleInformation.Command[] {        // Array of commands provided by the module
					new ModuleInformation.Command(
							"rm",             // Command name
							null,                    // Short command name
							null,                // Default subcommand without arguments
							"path",                    // Default subcommand with arguments
							new String[] { "path" }),  // Array of provided subcommands
			});
	// @formatter:on

	@Override
	public Message handleCommand(Command command) {
		return new Message("Not implemented");
	}

	@Override
	public void initLog(Context context) {
		LOG.initialize(Settings.getInstance(context));
	}

}

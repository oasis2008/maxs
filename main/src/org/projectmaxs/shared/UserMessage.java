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

package org.projectmaxs.shared;

import android.os.Parcel;
import android.os.Parcelable;

public class UserMessage implements Parcelable {

	private final int mId;
	private final String mTo;
	private final Message message;

	public UserMessage(Message msg) {
		mId = -1;
		mTo = null;
		message = msg;
	}

	public UserMessage(Message msg, String to) {
		this.mId = -1;
		this.mTo = to;
		this.message = msg;
	}

	public UserMessage(Message msg, String to, int id) {
		this.mId = id;
		this.mTo = to;
		this.message = msg;
	}

	public int getId() {
		return mId;
	}

	public String getTo() {
		return mTo;
	}

	public Message geMessage() {
		return message;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(mId);
		dest.writeString(mTo);
		dest.writeParcelable(message, flags);
	}

	public static final Creator<UserMessage> CREATOR = new Creator<UserMessage>() {

		@Override
		public UserMessage createFromParcel(Parcel source) {
			int id = source.readInt();
			String to = source.readString();
			Message msg = source.readParcelable(Message.class.getClassLoader());
			return new UserMessage(msg, to, id);
		}

		@Override
		public UserMessage[] newArray(int size) {
			return new UserMessage[size];
		}

	};

}
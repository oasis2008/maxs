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

package org.projectmaxs.shared.global.messagecontent;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import android.os.Parcel;

public class Element extends AbstractElement {

	protected final List<AbstractElement> mChildElements = new LinkedList<AbstractElement>();

	private final Text mHumanReadableName;
	private final String mXMLName;

	private String mText;

	public Element(String xmlName) {
		mXMLName = xmlName;
		mHumanReadableName = null;
	}

	public Element(String xmlName, String text) {
		this(xmlName);
		setText(text);
	}

	public Element(String xmlName, String text, Text humanReadableDescription) {
		mXMLName = xmlName;
		mHumanReadableName = humanReadableDescription;
		setText(text);
	}

	/**
	 * Note that text is only meant to be shown in XML, not in human readable
	 * format. Put all information in humanReadableName.
	 * 
	 * @param xmlName
	 * @param text
	 * @param humanReadableDescription
	 */
	public Element(String xmlName, String text, String humanReadableDescription) {
		this(xmlName, text, new Text(humanReadableDescription));
	}

	public void setText(String text) {
		mText = text;
	}

	public String getText() {
		return mText;
	}

	public boolean isHumanReadable() {
		return mHumanReadableName != null;
	}

	public Text getHumanReadableName() {
		return mHumanReadableName;
	}

	private Element(Parcel in) {
		mXMLName = in.readString();
		mHumanReadableName = in.readParcelable(getClass().getClassLoader());
		mText = in.readString();
		in.readList(mChildElements, AbstractElement.class.getClassLoader());
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(mXMLName);
		dest.writeParcelable(mHumanReadableName, flags);
		dest.writeString(mText);
		dest.writeList(mChildElements);
	}

	public static final Creator<Element> CREATOR = new Creator<Element>() {

		@Override
		public Element createFromParcel(Parcel source) {
			return new Element(source);
		}

		@Override
		public Element[] newArray(int size) {
			return new Element[size];
		}

	};

	public void addChildElement(AbstractElement element) {
		if (element == null) return;
		mChildElements.add(element);
	}

	public Iterator<AbstractElement> getChildElementIterator() {
		return mChildElements.iterator();
	}

}

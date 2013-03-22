/*
 Copyright 1995-2013 Esri

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

 For additional information, contact:
 Environmental Systems Research Institute, Inc.
 Attn: Contracts Dept
 380 New York Street
 Redlands, California, USA 92373

 email: contracts@esri.com
 */
package com.esri.core.geometry;

import org.json.JSONException;

public abstract class OperatorImportFromGeoJson extends Operator {
	@Override
	public Type getType() {
		return Type.ImportFromGeoJson;
	}

	/**
	 * Performs the ImportFromGeoJson operation.
	 * @param import_flags Use the {@link GeoJsonImportFlags} interface.
	 * @param type Use the {@link Geometry.Type} enum. 
	 * @param geoJsonString The string holding the Geometry in geoJson format.
	 * @return Returns the imported Geometry.
	 * @throws JSONException 
	 */
	public abstract MapGeometry execute(int import_flags, Geometry.Type type,
			String geoJsonString, ProgressTracker progress_tracker)
			throws JSONException;

	/**
	 * Performs the ImportFromGeoJson operation.
	 * @param import_flags Use the {@link GeoJsonImportFlags} interface.
	 * @param geoJsonString The string holding the Geometry in geoJson format.
	 * @return Returns the imported MapOGCStructure.
	 * @throws JSONException 
	 */
	public abstract MapOGCStructure executeOGC(int import_flags,
			String geoJsonString, ProgressTracker progress_tracker)
			throws JSONException;

	public static OperatorImportFromGeoJson local() {
		return (OperatorImportFromGeoJson) OperatorFactoryLocal.getInstance()
				.getOperator(Type.ImportFromGeoJson);
	}
}

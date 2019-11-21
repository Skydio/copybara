/*
 * Copyright (C) 2019 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.copybara.git.github.api;

import com.google.api.client.util.Key;
import com.google.common.base.MoreObjects;
import com.google.devtools.build.lib.skylarkinterface.SkylarkCallable;
import com.google.devtools.build.lib.skylarkinterface.SkylarkModule;
import com.google.devtools.build.lib.skylarkinterface.SkylarkModuleCategory;
import com.google.devtools.build.lib.skylarkinterface.SkylarkValue;
import javax.annotation.Nullable;

/** Descriptive details about the run.
 * https://developer.github.com/v3/checks/runs/#output-object
 */
@SkylarkModule(
    name = "output_obj",
    category = SkylarkModuleCategory.BUILTIN,
    doc = "Descriptive details about the run.")
public class Output implements SkylarkValue {

  @Key
  private String title;

  @Key
  @Nullable
  private String summary;

  @Key
  @Nullable
  private String text;

  @SkylarkCallable(
      name = "title",
      doc = "The title of the check run.",
      structField = true,
      allowReturnNones = true
  )
  public String getTitle() {
    return title;
  }

  @SkylarkCallable(
      name = "summary",
      doc = "The summary of the check run.",
      structField = true
  )
  public String getSummary() {
    return summary;
  }

  @SkylarkCallable(
      name = "text",
      doc = "The details of the check run.",
      structField = true,
      allowReturnNones = true
  )
  public String getText() {
    return text;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("title", title)
        .add("summary", summary)
        .add("text", text)
        .toString();
  }
}
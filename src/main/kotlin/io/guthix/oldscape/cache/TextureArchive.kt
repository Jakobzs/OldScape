/*
 * Copyright 2018-2020 Guthix
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.guthix.oldscape.cache

import io.guthix.js5.Js5Archive
import io.guthix.oldscape.cache.plane.Texture

public class TextureArchive(public val textures: List<Texture>) {
    public companion object {
        public const val id: Int = 9

        public fun load(archive: Js5Archive): TextureArchive {
            val textures = mutableListOf<Texture>()
            archive.groupSettings.forEach { (groupId, _) ->
                val group = archive.readGroup(groupId)
                group.files.forEach { (fileId, file) ->
                    textures.add(Texture.decode(fileId, file.data))
                }
            }
            return TextureArchive(textures)
        }
    }
}
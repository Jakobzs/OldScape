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
package io.guthix.oldscape.server.template

import io.guthix.oldscape.server.Property
import io.guthix.oldscape.server.stat.CombatBonus
import io.guthix.oldscape.server.stat.StyleBonus
import io.guthix.oldscape.server.world.entity.Obj
import io.guthix.oldscape.server.world.entity.interest.EquipmentType
import kotlinx.serialization.Serializable

val Obj.equipmentType: EquipmentType
    get() = equipmentTemplate.type ?: throw TemplateNotFoundException(id, Obj::equipmentType)

val Obj.attackBonus: StyleBonus
    get() = equipmentTemplate.attackBonus ?: throw TemplateNotFoundException(id, Obj::attackBonus)

val Obj.strengthBonus: CombatBonus
    get() = equipmentTemplate.strengthBonus ?: throw TemplateNotFoundException(id, Obj::strengthBonus)

val Obj.defenceBonus: StyleBonus
    get() = equipmentTemplate.defenceBonus ?: throw TemplateNotFoundException(id, Obj::defenceBonus)

val Obj.prayerBonus: Int
    get() = equipmentTemplate.prayerBonus ?: throw TemplateNotFoundException(id, Obj::prayerBonus)

internal val Obj.equipmentTemplate: EquipmentTemplate
    get() = template.equipment ?: throw TemplateNotFoundException(id, EquipmentTemplate::class)

internal val ObjTemplate.equipment: EquipmentTemplate? by Property { null }

@Serializable
data class EquipmentTemplate(
    override val ids: List<Int>,
    val type: EquipmentType? = null,
    val coversHair: Boolean? = null,
    val isFullBody: Boolean? = null,
    val coversFace: Boolean? = null,
    val attackBonus: StyleBonus? = null,
    val strengthBonus: CombatBonus? = null,
    val defenceBonus: StyleBonus? = null,
    val prayerBonus: Int? = null
) : Template
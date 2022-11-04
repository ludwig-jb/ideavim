/*
 * Copyright 2003-2022 The IdeaVim authors
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE.txt file or at
 * https://opensource.org/licenses/MIT.
 */

package org.jetbrains.plugins.ideavim.action

import com.maddyhome.idea.vim.VimPlugin
import com.maddyhome.idea.vim.api.injector
import com.maddyhome.idea.vim.helper.VimBehaviorDiffers
import org.jetbrains.plugins.ideavim.VimTestCase

class FileGetLocationInfoActionTest : VimTestCase() {
  @VimBehaviorDiffers(originalVimAfter = "Col 1 of 11; Line 1 of 6; Word 1 of 32; Byte 1 of 166")
  fun `test get file info`() {
    val keys = injector.parser.parseKeys("g<C-G>")
    val before = """
            ${c}A Discovery

            I found it in a legendary land
            all rocks and lavender and tufted grass,
            where it was settled on some sodden sand
            hard by the torrent of a mountain pass.
    """.trimIndent()
    configureByText(before)
    typeText(keys)
    assertEquals("Col 1 of 11; Line 1 of 6; Word 1 of 34; Character 1 of 165", VimPlugin.getMessage())
  }

  @VimBehaviorDiffers(originalVimAfter = "Col 1 of 11; Line 1 of 7; Word 1 of 32; Byte 1 of 167")
  fun `test get file info with empty line`() {
    val keys = injector.parser.parseKeys("g<C-G>")
    val before = """
            ${c}A Discovery

            I found it in a legendary land
            all rocks and lavender and tufted grass,
            where it was settled on some sodden sand
            hard by the torrent of a mountain pass.
            
    """.trimIndent()
    configureByText(before)
    typeText(keys)
    assertEquals("Col 1 of 11; Line 1 of 7; Word 1 of 35; Character 1 of 166", VimPlugin.getMessage())
  }

  @VimBehaviorDiffers(originalVimAfter = "Col 1 of 40; Line 4 of 7; Word 12 of 32; Byte 55 of 167")
  fun `test get file info in the middle`() {
    val keys = injector.parser.parseKeys("g<C-G>")
    val before = """
            A Discovery

            I found it in a legendary land
            all rocks ${c}and lavender and tufted grass,
            where it was settled on some sodden sand
            hard by the torrent of a mountain pass.
            
    """.trimIndent()
    configureByText(before)
    typeText(keys)
    assertEquals("Col 11 of 40; Line 4 of 7; Word 13 of 35; Character 55 of 166", VimPlugin.getMessage())
  }

  @VimBehaviorDiffers(originalVimAfter = "Col 1 of 0; Line 7 of 7; Word 32 of 32; Byte 167 of 167")
  fun `test get file info on the last line`() {
    val keys = injector.parser.parseKeys("g<C-G>")
    val before = """
            A Discovery

            I found it in a legendary land
            all rocks and lavender and tufted grass,
            where it was settled on some sodden sand
            hard by the torrent of a mountain pass.
            $c
    """.trimIndent()
    configureByText(before)
    typeText(keys)
    assertEquals("Col 1 of 1; Line 7 of 7; Word 35 of 35; Character 167 of 166", VimPlugin.getMessage())
  }
}

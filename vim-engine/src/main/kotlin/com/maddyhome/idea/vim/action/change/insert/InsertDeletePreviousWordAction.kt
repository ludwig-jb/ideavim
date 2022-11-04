/*
 * Copyright 2003-2022 The IdeaVim authors
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE.txt file or at
 * https://opensource.org/licenses/MIT.
 */
package com.maddyhome.idea.vim.action.change.insert

import com.maddyhome.idea.vim.api.ExecutionContext
import com.maddyhome.idea.vim.api.VimCaret
import com.maddyhome.idea.vim.api.VimEditor
import com.maddyhome.idea.vim.api.injector
import com.maddyhome.idea.vim.command.Argument
import com.maddyhome.idea.vim.command.Command
import com.maddyhome.idea.vim.command.CommandFlags
import com.maddyhome.idea.vim.command.OperatorArguments
import com.maddyhome.idea.vim.command.SelectionType
import com.maddyhome.idea.vim.common.TextRange
import com.maddyhome.idea.vim.handler.ChangeEditorActionHandler
import com.maddyhome.idea.vim.handler.Motion.AbsoluteOffset
import com.maddyhome.idea.vim.helper.enumSetOf
import java.util.*

class InsertDeletePreviousWordAction : ChangeEditorActionHandler.ForEachCaret() {
  override val type: Command.Type = Command.Type.INSERT

  override val flags: EnumSet<CommandFlags> = enumSetOf(CommandFlags.FLAG_CLEAR_STROKES)

  override fun execute(
    editor: VimEditor,
    caret: VimCaret,
    context: ExecutionContext,
    argument: Argument?,
    operatorArguments: OperatorArguments,
  ): Boolean {
    return insertDeletePreviousWord(editor, caret, operatorArguments)
  }
}

/**
 * Deletes the text from the cursor to the start of the previous word
 *
 *
 * TODO This behavior should be configured via the `backspace` option
 *
 * @param editor The editor to delete the text from
 * @return true if able to delete text, false if not
 */
fun insertDeletePreviousWord(editor: VimEditor, caret: VimCaret, operatorArguments: OperatorArguments): Boolean {
  val deleteTo: Int = if (caret.getLogicalPosition().column == 0) {
    caret.offset.point - 1
  } else {
    var pointer = caret.offset.point - 1
    val chars = editor.text()
    while (pointer >= 0 && chars[pointer] == ' ' && chars[pointer] != '\n') {
      pointer--
    }
    if (chars[pointer] == '\n') {
      pointer + 1
    } else {
      val motion = injector.motion.findOffsetOfNextWord(editor, pointer + 1, -1, false)
      if (motion is AbsoluteOffset) {
        motion.offset
      } else {
        return false
      }
    }
  }
  if (deleteTo < 0) {
    return false
  }
  val range = TextRange(deleteTo, caret.offset.point)
  injector.changeGroup.deleteRange(editor, caret, range, SelectionType.CHARACTER_WISE, true, operatorArguments)
  return true
}

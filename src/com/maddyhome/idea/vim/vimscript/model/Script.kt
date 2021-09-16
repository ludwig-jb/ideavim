package com.maddyhome.idea.vim.vimscript.model

import com.intellij.openapi.actionSystem.DataContext
import com.intellij.openapi.editor.Editor
import com.maddyhome.idea.vim.vimscript.model.datatypes.VimDataType
import com.maddyhome.idea.vim.vimscript.model.functions.FunctionHandler

data class Script(val units: List<Executable>) : Executable {

  /**
   * we store the "s:" scope variables and functions here
   * see ":h scope"
   */
  val scriptVariables: MutableMap<String, VimDataType> = mutableMapOf()
  val scriptFunctions: MutableMap<String, FunctionHandler> = mutableMapOf()

  override fun execute(editor: Editor, context: DataContext, vimContext: VimContext): ExecutionResult {
    var latestResult: ExecutionResult = ExecutionResult.Success
    for (unit in units) {
      if (latestResult is ExecutionResult.Success) {
        latestResult = unit.execute(editor, context, vimContext)
      } else {
        break
      }
    }
    return latestResult
  }
}

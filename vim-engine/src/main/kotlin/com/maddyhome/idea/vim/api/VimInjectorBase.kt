package com.maddyhome.idea.vim.api

import com.maddyhome.idea.vim.command.CommandState
import com.maddyhome.idea.vim.common.VimMachine
import com.maddyhome.idea.vim.diagnostic.VimLogger
import com.maddyhome.idea.vim.newapi.NativeActionManager
import com.maddyhome.idea.vim.options.OptionService

interface VimInjectorBase {
  val parser: VimStringParser
  val messages: VimMessages
  val registerGroup: VimRegisterGroup
  val registerGroupIfCreated: VimRegisterGroup?
  val processGroup: VimProcessGroup
  val application: VimApplication
  val executionContextManager: ExecutionContextManager
  val digraphGroup: VimDigraphGroup
  val vimMachine: VimMachine
  val enabler: VimEnabler

  // TODO We should somehow state that [OptionServiceImpl] can be used from any implementation
  val optionService: OptionService
  val nativeActionManager: NativeActionManager
  val keyGroup: VimKeyGroup
  val markGroup: VimMarkGroup
  val visualMotionGroup: VimVisualMotionGroup
  fun <T : Any> getLogger(clazz: Class<T>): VimLogger
  fun commandStateFor(editor: VimEditor): CommandState
  val engineEditorHelper: EngineEditorHelper
}

lateinit var injectorBase: VimInjectorBase
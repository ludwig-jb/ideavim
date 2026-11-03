<img src="src/main/resources/META-INF/pluginIcon.svg" width="80" height="80" alt="imago" align="left"/>

IdeaVim
===

[![Opus officiale JetBrains][jb-official-svg]][jb-official]
[![Collationes gratae sunt][contributions-welcome-svg]][contributions-welcome]
[![Recepta][plugin-downloads-svg]][plugin-repo]
[![Aestimatio][plugin-rating-svg]][plugin-repo]
[![Versio][plugin-version-svg]][plugin-repo]
[![Gitter][gitter-svg]][gitter]
[![codecov](https://codecov.io/gh/JetBrains/ideavim/branch/master/graph/badge.svg)](https://codecov.io/gh/JetBrains/ideavim)
[![Twitter][twitter-svg]][twitter]

IdeaVim est machina Vim pro ambitibus evolutionis integratis (IDE) JetBrains.

##### Curatores adire:
* [Index vitiorum](https://youtrack.jetbrains.com/issues/VIM)
* [@IdeaVim](https://twitter.com/ideavim) in Twitter
* [Colloquium in Gitter](https://gitter.im/JetBrains/ideavim)
* [Canalis IdeaVim](https://jb.gg/bi6zp7) in [ministratore JetBrains](https://discord.gg/jetbrains)

##### Opes:

* [Pagina principalis additamenti](https://lp.jetbrains.com/ideavim/)
* [Additamentum in Marketplace](https://plugins.jetbrains.com/plugin/164-ideavim)
* [Index mutationum](CHANGES.md)
* [Versiones integratione continua constructae](https://ideavim.teamcity.com/)

#### Convenientia

IntelliJ IDEA, PyCharm, GoLand, CLion, PhpStorm, WebStorm, RubyMine, DataGrip, DataSpell, Rider, Cursive,
Android Studio aliique [ambitus IDE JetBrains](https://www.jetbrains.com/ides/).

Institutio
------------

- IdeaVim per `Settings | Plugins` institui potest.
Vide [praecepta accurata](https://www.jetbrains.com/help/idea/managing-plugins.html#).

- Utere `Tools | Vim` in indice optionum ad Vim activandum vel deactivandum.

- Utere fasciculo `~/.ideavimrc` ad similitudinem `~/.vimrc` ([plura disce](#fasciculi)). Norma XDG quoque sustinetur.

- Conflictus inter clavium compendia componi possunt his modis:
     - In Linux et Windows: `File | Settings | Editor | Vim` et `File | Settings | Keymap`,
     - In macOS: `Preferences | Editor | Vim` et `Preferences | Keymap`,
     - Usitatis clavium assignationibus Vim in fasciculo `~/.ideavimrc`.

Accessus praematurus
-------------------

Visne novas facultates et emendationes experiri? Programma Accessus Praematuri (EAP) ingredere et
versiones EAP tamquam renovationes accipe!\

1. Preme imaginem IdeaVim <img src="src/main/resources/META-INF/pluginIcon_noBorders.svg" width="16" height="16" alt="imago"/>
in vecte status | `Early Access Program` | `Subscribe to EAP`


Vel renovationibus EAP manu subscribe:

1. Aperi `Settings | Plugins`
2. Preme imaginem rotae dentatae :gear:, elige `Manage Plugin Repositories`, et hanc inscriptionem URL adde:
```
https://plugins.jetbrains.com/plugins/eap/ideavim
```

Vide [indicem mutationum](CHANGES.md) pro indice facultatum nondum editarum.

Interest versiones EAP a programmatibus usitatis ante editionem publicam distinguere.
Memento qualitatem versionum EAP interdum multo inferiorem esse posse quam
quae etiam a versionibus beta usitatis exspectetur.

Sententiam tuam semper his viis communicare potes:
* [@IdeaVim](https://twitter.com/ideavim) in Twitter
* [Index vitiorum](https://youtrack.jetbrains.com/issues/VIM)


Conspectus facultatum Vim sustentatarum
---------------------------------

Haec sunt exempla nonnullarum facultatum et mandatorum Vim quae sustinentur:

* Modi ordinarius / inserendi / visualis / eligendi / ceteri
* Mandata motus / deletionis / mutationis / fenestrarum / cetera
* Clavium assignationes
* Notae / Macroinstructiones / Digrammata / Registra
* Quaedam [mandata set](https://github.com/JetBrains/ideavim/wiki/set-commands)
* Plenae expressiones regulares Vim ad quaerendum et ad quaerendum/substituendum
* Auxilium Vim in interrete
* Fasciculus configurationis `~/.ideavimrc`
* Vim script, quibusdam [functionibus internis](vimscript-info/FUNCTIONS_INFO.MD) inclusis
* Additamenta IdeaVim

Vide etiam:

* [Petitiones facultatum et vitia plurimis suffragiis accepta](https://youtrack.jetbrains.com/issues/VIM?q=%23Unresolved+sort+by%3A+votes)

Fasciculi
-----

* `~/.ideavimrc`
    * Mandata tua initializationis Vim propria IdeaVim

<details>
<summary><strong>Exemplum</strong> (preme ut videas)</summary>

```vim
""" Clavem principalem spatio assigna -------
let mapleader=" "

""" Additamenta -----------------------------
set surround
set multiple-cursors
set commentary
set argtextobj
set easymotion
set textobj-entire
set ReplaceWithRegister

""" Optiones additamentorum ------------------
let g:argtextobj_pairs="[:],(:),<:>"

""" Optiones communes -----------------------
set showmode
set so=5
set incsearch
set nu

""" Optiones propriae IDEA -------------------
set ideajoin
set ideastatusicon=gray
set idearefactormode=keep

""" Clavium assignationes --------------------
map <leader>f <Plug>(easymotion-s)
map <leader>e <Plug>(easymotion-f)

map <leader>d <Action>(Debug)
map <leader>r <Action>(RenameElement)
map <leader>c <Action>(Stop)
map <leader>z <Action>(ToggleDistractionFreeMode)

map <leader>s <Action>(SelectInProjectView)
map <leader>a <Action>(Annotate)
map <leader>h <Action>(Vcs.ShowTabbedFileHistory)
map <S-Space> <Action>(GotoNextError)

map <leader>b <Action>(ToggleLineBreakpoint)
map <leader>o <Action>(FileStructurePopup)
```
</details>

<details>
<summary><strong>Optiones commendatae</strong> (preme ut videas)</summary>

Hic quoque est index optionum commendatarum ex [defaults.vim](https://github.com/vim/vim/blob/master/runtime/defaults.vim)

```vim
" Aliquot lineas circa cursorem ostende. Hoc textum volvi facit,
" si mure prope initium vel finem fenestrae premis.
set scrolloff=5

" Quaere dum scribis.
set incsearch

" Modo Ex ne utaris; utere Q ad textum formandum.
map Q gq
```
</details>


Fasciculum tuum `~/.vimrc` ex `~/.ideavimrc` hoc mandato legere potes:

    source ~/.vimrc

Memento etiam, si optionem JVM `user.home` mutaveris, hoc
locum afficere in quo IdeaVim fasciculum tuum `.ideavimrc` quaerit. Exempli gratia, si
`-Duser.home=/my/alternate/home` posueris, IdeaVim
`/my/alternate/home/.ideavimrc` loco `~/.ideavimrc` leget et exsequetur.

Vel mandata initializationis secundum normam [XDG](https://specifications.freedesktop.org/basedir-spec/basedir-spec-latest.html) constituere potes.
Optiones tuas in fasciculo `$XDG_CONFIG_HOME/ideavim/ideavimrc` pone.


Additamenta IdeaVim
--------------------

Vide [doc/IdeaVim Plugins.md](https://github.com/JetBrains/ideavim/wiki/IdeaVim-Plugins)

Actiones IDE exsequi
---------------------

IdeaVim varia mandata addit ad quaslibet actiones IDE enumerandas et exsequendas tamquam
mandata Ex vel per assignationes mandati `:map`:

### Actiones exsequi:
* `<Action>({action_id})`
    * In assignationibus verbo speciali `<Action>` uti potes. Parentheses ne omiseris.
    * Exempli gratia, `map gh <Action>(ShowErrorDescription)` <- indicium superpositum per `gh` ostende.
    * :warning: Assignationes ad `<Action>` cum `noremap` non operantur.
      Si casum nosti in quo hoc opus sit, [nobis indica](https://github.com/JetBrains/ideavim#contact-maintainers).
* `:action {action_id}`
    * Actionem per `{action_id}` exsequere. Ex linea mandatorum Ex operatur.
    * Noli `:action` in assignationibus uti. Utere `<Action>`.

### Identificatores actionum invenire:

* IJ mandatum `IdeaVim: track action IDs` praebet ad identificatores actionum exsecutarum ostendendos.
  Hoc mandatum in "Search everywhere" (bis `shift`) inveniri potest.

    <details>
        <summary><strong>Singula de "Track action IDs"</strong> (preme ut videas)</summary>
        <picture>
            <source media="(prefers-color-scheme: dark)" srcset="assets/readme/track_action_dark.gif">
            <img src="assets/readme/track_action_light.gif" alt="identificatores actionum persequi"/>
        </picture>
    </details>


* `:actionlist [pattern]`
    * Actiones IDE per identificatorem vel exemplar assignationis clavium inveni (exempli gratia, `:actionlist extract`, `:actionlist <C-D`)

##### Exempla:

```vim
" Assigna \r actioni Reformat Code
:map \r <Action>(ReformatCode)

" Assigna <leader>d ad vitia investiganda
:map <leader>d <Action>(Debug)

" Assigna \b ad punctum interruptionis in linea praesenti alternandum
:map \b <Action>(ToggleLineBreakpoint)
```

##### Quaedam actiones frequentes:

```
ShowHoverInfo - Documentatio celeris et descriptio erroris
QuickImplementations - Definitio celeris
```

Vim Script
------------

IdeaVim scripta propria lingua Vim Script conscripta exsequi potest.
Nunc omnes facultates linguae sustinemus, sed non omnes functiones internae et optiones sustinentur.

Praeterea tibi fortasse placebit
[disputatio de Vim Script](https://github.com/JetBrains/ideavim/discussions/357).


### Optiones propriae IDE

Vocationem functionis `has('ide')` aestimare potes et `1` accipies si per IdeaVim vocata est, vel `0` si ex Vim/NeoVim vocata est.\
Optio `&ide` nomen et editionem ambitus tui IDE continet, exempli gratia, "IntelliJ IDEA Ultimate Edition".\
Ut valorem eius pro ambitu IDE quo nunc uteris videas, mandatum `:echo &ide` exsequere.\
Ad configurationem propriam ambitus IDE scribendam, utere operatoribus Vim ad expressiones regulares comparandas `=~?` (sine discrimine litterarum maiuscularum et minuscularum) / `=~#` (cum discrimine litterarum maiuscularum et minuscularum)

**Exemplum configurationis:**

```vim
" optiones et assignationes quae et a Vim et ab IdeaVim sustinentur
set nu
set relativenumber

if has('ide')
  " assignationes et optiones quae tantum in IdeaVim exstant
  map <leader>f <Action>(GotoFile)
  map <leader>g <Action>(FindInPath)
  map <leader>b <Action>(Switcher)

  if &ide =~? 'intellij idea'
    if &ide =~? 'community'
      " quaedam assignationes et optiones pro IntelliJ IDEA Community Edition
    elseif &ide =~? 'ultimate'
      " quaedam assignationes et optiones pro IntelliJ IDEA Ultimate Edition
    endif
  elseif &ide =~? 'pycharm'
    " assignationes et optiones propriae PyCharm
  endif
else
  " quaedam assignationes pro Vim/Neovim
  nnoremap <leader>f <cmd>Telescope find_files<cr>
endif
```

:gem: Conferre
------------

Vis collationum IdeaVim promovet :muscle:. Etiam parvae collationes valent!

Vide ducem ad conferendum in [CONTRIBUTING.md](CONTRIBUTING.md), ut operi prodesse incipias.

😎 Anno 2025, programma praemiorum instituimus. Singula in duce vide.

Auctores
-------

Vide [AUTHORS.md](AUTHORS.md)
pro indice auctorum et collatorum.

Consilia et artificia IdeaVim
-------

- Utere facultatibus IJ et Vim:
    - `set ideajoin` ad lineas per IDE iungendas. Vide [exempla](https://jb.gg/f9zji9).
    - Cura ut `ideaput` pro `clipboard` activum sit, ut Vim insertione nativa IJ uti possit.
    - Notas librarias IJ et notas globales IdeaVim inter se congruere fac: `set ideamarks` (tantum pro notis litteris maiusculis signatis operatur)
    - Plura [mandata ex](https://github.com/JetBrains/ideavim/wiki/set-commands) inspice.

- Utere optionibus tuis Vim cum IdeaVim. Pone `source ~/.vimrc` in `~/.ideavimrc`.
- Imaginem vectis status rege per [optionem `ideastatusicon`](https://github.com/JetBrains/ideavim/wiki/set-commands).
- Mores ordinarios inter codicem restructurandum ignoras? Vide [optionem `idearefactormode`](https://github.com/JetBrains/ideavim/wiki/set-commands).

Quaedam de Vim
-------

Nunc paulisper requiescamus et oblectemur! Haec sunt nonnulla quae inter evolutionem iucunda invenimus
et tecum communicare volumus.

- Mandata qualia `dd`, `yy`, vel `cc` non exstant. Exempli gratia, `dd` non est mandatum separatum ad lineam delendam,
sed mandatum `d` cum motu `d`.\
At motus `d` in Vim non exstat! Recte; ideo Vim habet peculiarem seriem mandatorum
pro quibus examinat num
[mandatum motui aequale sit](https://github.com/vim/vim/blob/759d81549c1340185f0d92524c563bb37697ea88/src/normal.c#L6468)
et, si ita est, motum `_` eius loco exsequitur.\
`_` est motus singularis, qui ne in vi quidem documentatus est, et ad lineam praesentem pertinet.
Ita mandata qualia `dd`, `yy`, et similia simpliciter in `d_`, `y_`, etc. convertuntur.
[Hic](https://github.com/vim/vim/blob/759d81549c1340185f0d92524c563bb37697ea88/src/normal.c#L6502)
fons huius scientiae est.

- Ne `x`, `D`, et `&` quidem mandata separata sunt. Sunt synonyma mandatorum `dl`, `d$`, et `:s\r`, respective.
[Hic](https://github.com/vim/vim/blob/759d81549c1340185f0d92524c563bb37697ea88/src/normal.c#L5365)
est plenus index synonymorum.

- Legere potes [commentarium](https://github.com/JetBrains/ideavim/wiki/how-many-modes-does-vim-have) de modis in Vim et IdeaVim operantibus.

- Num umquam `U` post `dd` usus es? [Ne conatus quidem sis](https://github.com/vim/vim/blob/759d81549c1340185f0d92524c563bb37697ea88/src/ops.c#L874).

- Multae variabiles quae ad modum visualem pertinent duabus litteris maiusculis incipiunt, exempli gratia, `VIsual_active`. [Quaedam exempla](https://github.com/vim/vim/blob/master/src/normal.c#L17).
  Ut [hic](https://vi.stackexchange.com/a/42885/12441) memoratur, hoc factum est ad conflictum cum X11 vitandum.

- Alia [mira](https://github.com/vim/vim/blob/759d81549c1340185f0d92524c563bb37697ea88/src/ex_docmd.c#L1845) ex vi:
    * ":3"       ad lineam 3 transit
    * ":3|..."   lineam 3 imprimit
    * ":|"       lineam praesentem imprimit

- Vim script spatia ante comma non praeterit. `F(a ,b)` => E475.

- Constantes singulares pro [undolevels](https://vimhelp.org/options.txt.html#%27undolevels%27):
  > Valor localis ad -123456 constituitur cum valor globalis adhibendus est.

- Vi (non Vim) norma POSIX est et [specificationem habet](https://pubs.opengroup.org/onlinepubs/9699919799/utilities/vi.html)! Vim plerumque normae POSIX congruit cum convenientia cum Vi per optionem `'compatible'` eligitur, sed quaedam differentiae manent quae per `'copoptions'` mutari possunt. Specificatio iucunda est quia mores diversorum mandatorum accuratius quam documentatio usorum describit, exempli gratia lineam et columnam praesentes post mandatum indicans. [Plura legendo `:help posix` inveniri possunt](https://vimhelp.org/vi_diff.txt.html#posix).

- Documentatio Vim multas iocosas res occultas continet. Eas interdum invenimus, sed usor GitHub mikesmithgh amplam collectionem [hic](https://github.com/mikesmithgh/vimpromptu) composuit.
  - Praeter `:call err_teapot()`, quod `E418: I'm a teapot` reddit, est etiam `:call err_teapot(1)`, quod `E503: Coffee is currently not available` reddit. Scilicet hoc quoque in IdeaVim sustinetur.

- In modo inserendi omnes claves `Ctrl` assignatae sunt praeter `Ctrl-B`. In documentatione hoc notatur verbis **"CTRL-B in Insert
  mode gone"**. Voca `:h i_CTRL-B-gone` in Vim ut legas cur `Ctrl-B` remotum sit.

Licentia
-------

IdeaVim sub licentia MIT distribuitur.

Partes ab aliis auctoribus confectae earumque licentiae in [ThirdPartyLicenses.md](ThirdPartyLicenses.md) enumerantur.

Omnes versiones ante 2.0.0 sub condicionibus GPL-2.0 vel posterioris distributae sunt.
Ultima consignatio ante transitum ad MIT est 05852b07c6090ad40fde7d3cafe0b074604f7ac5.
Plura de mutatione licentiae hic legere potes: https://github.com/JetBrains/ideavim/discussions/543


<!-- Insignia -->
[jb-official]: https://confluence.jetbrains.com/display/ALL/JetBrains+on+GitHub
[jb-official-svg]: https://jb.gg/badges/official.svg

[plugin-repo]: https://plugins.jetbrains.com/plugin/164-ideavim
[plugin-downloads-svg]: http://img.shields.io/jetbrains/plugin/d/IdeaVIM
[plugin-rating-svg]: http://img.shields.io/jetbrains/plugin/r/rating/IdeaVIM
[plugin-version-svg]: https://img.shields.io/jetbrains/plugin/v/ideavim?label=version

[gitter-svg]: https://badges.gitter.im/JetBrains/ideavim.svg
[gitter]: https://gitter.im/JetBrains/ideavim?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge

[twitter]: https://twitter.com/ideavim
[twitter-svg]: https://img.shields.io/twitter/follow/ideavim?label=twitter%20%40ideavim

[contributions-welcome-svg]: http://img.shields.io/badge/contributions-welcome-brightgreen
[contributions-welcome]: https://github.com/JetBrains/ideavim/blob/master/CONTRIBUTING.md

package dev.skir.cmds

import dev.jorel.commandapi.CommandAPICommand
import dev.jorel.commandapi.arguments.*
import dev.jorel.commandapi.executors.CommandExecutor
import dev.skir.config.Settings
import dev.skir.config.languages.LM
import dev.skir.funs.*
import org.bukkit.entity.Player

class Visual {
    companion object {
        fun register() {
            CommandAPICommand(Settings.i().commands.visual)
                .withPermission(Settings.i().permissions.visual_show)
                .withSubcommand(CommandAPICommand("fullscreen")
                    .withArguments(EntitySelectorArgument.ManyPlayers("players"))
                    .withArguments(TextArgument("text"))
                    .withArguments(AdventureChatColorArgument("color"))
                    .withOptionalArguments(BooleanArgument("freeze"))
                    .withOptionalArguments(IntegerArgument("fadeIn"))
                    .withOptionalArguments(IntegerArgument("stay"))
                    .withOptionalArguments(IntegerArgument("fadeOut"))
                    .executes(CommandExecutor { sender, args ->
                        if (!Settings.i().visualToggles.fullscreen){
                            var message = LM.i().getLocale().general.thisVisualIsDisabled
                            message = message.replace("%prefix%", LM.i().getLocale().general.prefix)
                            sender.sendMessage(Color.format(message))
                            return@CommandExecutor
                        }
                        // Showing a full screen visual
                        if (args.get("fadeIn") != null && args.get("stay") != null && args.get("fadeOut") != null) {
                            // Show a fullscreen visual with timings
                            var message = LM.i().getLocale().shownVisuals.fullscreen_timings
                            message = message.replace("%prefix%", LM.i().getLocale().general.prefix)
                            val targetDisplay = Targets.formatPlayerTargets(args.get("players") as Collection<Player>)
                            message = message.replace("%target%", targetDisplay)
                            message = message.replace("%text%", args.get("text") as String)
                            message = message.replace("%fadeIn%", args.get("fadeIn").toString())
                            message = message.replace("%stay%", args.get("stay").toString())
                            message = message.replace("%fadeOut%", args.get("fadeOut").toString())

                            FullscreenVisual.show(args.get("players") as Collection<Player>, args.get("text") as String, "<${args.get("color")}>", args.get("freeze") as Boolean, args.get("fadeIn") as Int, args.get("stay") as Int, args.get("fadeOut") as Int)
                            sender.sendMessage(Color.format(message))
                        } else {
                            // Show a fullscreen visual without timings
                            var message = LM.i().getLocale().shownVisuals.fullscreen_no_timings
                            message = message.replace("%prefix%", LM.i().getLocale().general.prefix)
                            val targetDisplay = Targets.formatPlayerTargets(args.get("players") as Collection<Player>)
                            message = message.replace("%target%", targetDisplay)
                            message = message.replace("%text%", args.get("text") as String)

                            var freeze: Boolean
                            if (args.get("freeze") == null) {
                                freeze = Settings.i().defaults.freeze
                            }else{
                                freeze = args.get("freeze") as Boolean
                            }

                            FullscreenVisual.show(args.get("players") as Collection<Player>, args.get("text") as String, "<${args.get("color")}>", freeze, Settings.i().defaults.timings.fadeIn, Settings.i().defaults.timings.stay, Settings.i().defaults.timings.fadeOut)
                            sender.sendMessage(Color.format(message))
                        }
                    })
                )
                .withSubcommand(CommandAPICommand("transparent")
                    .withArguments(EntitySelectorArgument.ManyPlayers("players"))
                    .withArguments(TextArgument("text"))
                    .withArguments(AdventureChatColorArgument("color"))
                    .withOptionalArguments(BooleanArgument("freeze"))
                    .withOptionalArguments(IntegerArgument("fadeIn"))
                    .withOptionalArguments(IntegerArgument("stay"))
                    .withOptionalArguments(IntegerArgument("fadeOut"))
                    .executes(CommandExecutor { sender, args ->
                        if (!Settings.i().visualToggles.transparent){
                            var message = LM.i().getLocale().general.thisVisualIsDisabled
                            message = message.replace("%prefix%", LM.i().getLocale().general.prefix)
                            sender.sendMessage(Color.format(message))
                            return@CommandExecutor
                        }
                        // Showing a full screen visual
                        if (args.get("fadeIn") != null && args.get("stay") != null && args.get("fadeOut") != null) {
                            // Show a fullscreen visual with timings
                            var message = LM.i().getLocale().shownVisuals.transparent_timings
                            message = message.replace("%prefix%", LM.i().getLocale().general.prefix)
                            val targetDisplay = Targets.formatPlayerTargets(args.get("players") as Collection<Player>)
                            message = message.replace("%target%", targetDisplay)
                            message = message.replace("%text%", args.get("text") as String)
                            message = message.replace("%fadeIn%", args.get("fadeIn").toString())
                            message = message.replace("%stay%", args.get("stay").toString())
                            message = message.replace("%fadeOut%", args.get("fadeOut").toString())

                            TransparentVisual.show(args.get("players") as Collection<Player>, args.get("text") as String, "<${args.get("color")}>", args.get("freeze") as Boolean, args.get("fadeIn") as Int, args.get("stay") as Int, args.get("fadeOut") as Int)
                            sender.sendMessage(Color.format(message))
                        } else {
                            // Show a fullscreen visual without timings
                            var message = LM.i().getLocale().shownVisuals.transparent_no_timings
                            message = message.replace("%prefix%", LM.i().getLocale().general.prefix)
                            val targetDisplay = Targets.formatPlayerTargets(args.get("players") as Collection<Player>)
                            message = message.replace("%target%", targetDisplay)
                            message = message.replace("%text%", args.get("text") as String)

                            var freeze: Boolean
                            if (args.get("freeze") == null) {
                                freeze = Settings.i().defaults.freeze
                            }else{
                                freeze = args.get("freeze") as Boolean
                            }

                            TransparentVisual.show(args.get("players") as Collection<Player>, args.get("text") as String, "<${args.get("color")}>", freeze, Settings.i().defaults.timings.fadeIn, Settings.i().defaults.timings.stay, Settings.i().defaults.timings.fadeOut)
                            sender.sendMessage(Color.format(message))
                        }
                    })
                )
                .withSubcommand(CommandAPICommand("freezing")
                    .withArguments(EntitySelectorArgument.ManyPlayers("players"))
                    .withArguments(TextArgument("title"))
                    .withArguments(TextArgument("subtitle"))
                    .withOptionalArguments(BooleanArgument("freeze"))
                    .withOptionalArguments(IntegerArgument("fadeIn"))
                    .withOptionalArguments(IntegerArgument("stay"))
                    .withOptionalArguments(IntegerArgument("fadeOut"))
                    .executes(CommandExecutor { sender, args ->
                        if (!Settings.i().visualToggles.freezing){
                            var message = LM.i().getLocale().general.thisVisualIsDisabled
                            message = message.replace("%prefix%", LM.i().getLocale().general.prefix)
                            sender.sendMessage(Color.format(message))
                            return@CommandExecutor
                        }
                        
                        if (args.get("fadeIn") != null && args.get("stay") != null && args.get("fadeOut") != null) {
                            // Show a fullscreen visual with timings
                            var message = LM.i().getLocale().shownVisuals.freezing_timings
                            message = message.replace("%prefix%", LM.i().getLocale().general.prefix)
                            val targetDisplay = Targets.formatPlayerTargets(args.get("players") as Collection<Player>)
                            message = message.replace("%target%", targetDisplay)
                            message = message.replace("%title%", args.get("title") as String)
                            message = message.replace("%subtitle%", args.get("subtitle") as String)
                            message = message.replace("%fadeIn%", args.get("fadeIn").toString())
                            message = message.replace("%stay%", args.get("stay").toString())
                            message = message.replace("%fadeOut%", args.get("fadeOut").toString())

                            FreezingVisual.show(args.get("players") as Collection<Player>, args.get("title") as String, args.get("subtitle") as String, args.get("freeze") as Boolean, args.get("fadeIn") as Int, args.get("stay") as Int, args.get("fadeOut") as Int)
                            sender.sendMessage(Color.format(message))
                        } else {
                            // Show a fullscreen visual without timings
                            var message = LM.i().getLocale().shownVisuals.freezing_no_timings
                            message = message.replace("%prefix%", LM.i().getLocale().general.prefix)
                            val targetDisplay = Targets.formatPlayerTargets(args.get("players") as Collection<Player>)
                            message = message.replace("%target%", targetDisplay)
                            message = message.replace("%title%", args.get("title") as String)
                            message = message.replace("%subtitle%", args.get("subtitle") as String)

                            var freeze: Boolean
                            if (args.get("freeze") == null) {
                                freeze = Settings.i().defaults.freeze
                            }else{
                                freeze = args.get("freeze") as Boolean
                            }

                            FreezingVisual.show(args.get("players") as Collection<Player>, args.get("title") as String, args.get("subtitle") as String, freeze, Settings.i().defaults.timings.fadeIn, Settings.i().defaults.timings.stay, Settings.i().defaults.timings.fadeOut)
                            sender.sendMessage(Color.format(message))
                        }
                    })
                )
                .withSubcommand(CommandAPICommand("gradient")
                    .withSubcommand(CommandAPICommand("fullscreen")
                        .withArguments(EntitySelectorArgument.ManyPlayers("players"))
                        .withArguments(TextArgument("text"))
                        .withArguments(AdventureChatColorArgument("color"))
                        .withOptionalArguments(BooleanArgument("freeze"))
                        .withOptionalArguments(IntegerArgument("fadeIn"))
                        .withOptionalArguments(IntegerArgument("stay"))
                        .withOptionalArguments(IntegerArgument("fadeOut"))
                        .executes(CommandExecutor { sender, args ->
                            if (!Settings.i().visualToggles.gradient_fullscreen){
                                var message = LM.i().getLocale().general.thisVisualIsDisabled
                                message = message.replace("%prefix%", LM.i().getLocale().general.prefix)
                                sender.sendMessage(Color.format(message))
                                return@CommandExecutor
                            }
                            // Showing a full screen visual
                            if (args.get("fadeIn") != null && args.get("stay") != null && args.get("fadeOut") != null) {
                                // Show a fullscreen visual with timings
                                var message = LM.i().getLocale().shownVisuals.fullscreen_gradient_timings
                                message = message.replace("%prefix%", LM.i().getLocale().general.prefix)
                                val targetDisplay = Targets.formatPlayerTargets(args.get("players") as Collection<Player>)
                                message = message.replace("%target%", targetDisplay)
                                message = message.replace("%text%", args.get("text") as String)
                                message = message.replace("%fadeIn%", args.get("fadeIn").toString())
                                message = message.replace("%stay%", args.get("stay").toString())
                                message = message.replace("%fadeOut%", args.get("fadeOut").toString())

                                FullscreenGradientVisual.show(args.get("players") as Collection<Player>, args.get("text") as String, "<${args.get("color")}>", args.get("freeze") as Boolean, args.get("fadeIn") as Int, args.get("stay") as Int, args.get("fadeOut") as Int)
                                sender.sendMessage(Color.format(message))
                            } else {
                                // Show a fullscreen visual without timings
                                var message = LM.i().getLocale().shownVisuals.fullscreen_gradient_no_timings
                                message = message.replace("%prefix%", LM.i().getLocale().general.prefix)
                                val targetDisplay = Targets.formatPlayerTargets(args.get("players") as Collection<Player>)
                                message = message.replace("%target%", targetDisplay)
                                message = message.replace("%text%", args.get("text") as String)

                                var freeze: Boolean
                                if (args.get("freeze") == null) {
                                    freeze = Settings.i().defaults.freeze
                                }else{
                                    freeze = args.get("freeze") as Boolean
                                }

                                FullscreenGradientVisual.show(args.get("players") as Collection<Player>, args.get("text") as String, "<${args.get("color")}>", freeze, Settings.i().defaults.timings.fadeIn, Settings.i().defaults.timings.stay, Settings.i().defaults.timings.fadeOut)
                                sender.sendMessage(Color.format(message))
                            }
                        })
                    )
                )
                .register()
        }
    }
}
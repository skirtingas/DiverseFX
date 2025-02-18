package net.starfal.cmds

import dev.jorel.commandapi.CommandAPICommand
import dev.jorel.commandapi.SuggestionInfo
import dev.jorel.commandapi.arguments.*
import dev.jorel.commandapi.executors.CommandExecutor
import net.starfal.config.Settings
import net.starfal.config.languages.LM
import net.starfal.funs.*
import org.bukkit.Bukkit
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player


class Visual {
    companion object {
        fun register() {
            val noSelectorSuggestions = PlayerArgument("player")
                .replaceSafeSuggestions(SafeSuggestions.suggest {
                    Bukkit.getOnlinePlayers().toTypedArray()
                })

            CommandAPICommand(Settings.i().commands.visual)
                .withPermission(Settings.i().permissions.visual_show)
                .withSubcommand(CommandAPICommand("fullscreen")
                    .withArguments(noSelectorSuggestions)
                    .withArguments(TextArgument("text"))
                    .withArguments(AdventureChatColorArgument("color"))
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
                            message = message.replace("%target%", (args.get("player") as Player).name)
                            message = message.replace("%text%", args.get("text") as String)
                            message = message.replace("%fadeIn%", args.get("fadeIn").toString())
                            message = message.replace("%stay%", args.get("stay").toString())
                            message = message.replace("%fadeOut%", args.get("fadeOut").toString())

                            FullscreenVisual.show(args.get("player") as Player, args.get("text") as String, "<${args.get("color")}>", args.get("fadeIn") as Int, args.get("stay") as Int, args.get("fadeOut") as Int)
                            sender.sendMessage(Color.format(message))
                        } else {
                            // Show a fullscreen visual without timings
                            var message = LM.i().getLocale().shownVisuals.fullscreen_no_timings
                            message = message.replace("%prefix%", LM.i().getLocale().general.prefix)
                            message = message.replace("%target%", (args.get("player") as Player).name)
                            message = message.replace("%text%", args.get("text") as String)
                            FullscreenVisual.show(args.get("player") as Player, args.get("text") as String, "<${args.get("color")}>", Settings.i().timings.fadeIn, Settings.i().timings.stay, Settings.i().timings.fadeOut)
                            sender.sendMessage(Color.format(message))
                        }
                    })
                )
                .withSubcommand(CommandAPICommand("transparent")
                    .withArguments(noSelectorSuggestions)
                    .withArguments(TextArgument("text"))
                    .withArguments(AdventureChatColorArgument("color"))
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
                            message = message.replace("%target%", (args.get("player") as Player).name)
                            message = message.replace("%text%", args.get("text") as String)
                            message = message.replace("%fadeIn%", args.get("fadeIn").toString())
                            message = message.replace("%stay%", args.get("stay").toString())
                            message = message.replace("%fadeOut%", args.get("fadeOut").toString())

                            TransparentVisual.show(args.get("player") as Player, args.get("text") as String, "<${args.get("color")}>", args.get("fadeIn") as Int, args.get("stay") as Int, args.get("fadeOut") as Int)
                            sender.sendMessage(Color.format(message))
                        } else {
                            // Show a fullscreen visual without timings
                            var message = LM.i().getLocale().shownVisuals.transparent_no_timings
                            message = message.replace("%prefix%", LM.i().getLocale().general.prefix)
                            message = message.replace("%target%", (args.get("player") as Player).name)
                            message = message.replace("%text%", args.get("text") as String)

                            TransparentVisual.show(args.get("player") as Player, args.get("text") as String, "<${args.get("color")}>", Settings.i().timings.fadeIn, Settings.i().timings.stay, Settings.i().timings.fadeOut)
                            sender.sendMessage(Color.format(message))
                        }
                    })
                )
                .withSubcommand(CommandAPICommand("freezing")
                    .withArguments(noSelectorSuggestions)
                    .withArguments(TextArgument("title"))
                    .withArguments(TextArgument("subtitle"))
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
                            message = message.replace("%target%", (args.get("player") as Player).name)
                            message = message.replace("%title%", args.get("title") as String)
                            message = message.replace("%subtitle%", args.get("subtitle") as String)
                            message = message.replace("%fadeIn%", args.get("fadeIn").toString())
                            message = message.replace("%stay%", args.get("stay").toString())
                            message = message.replace("%fadeOut%", args.get("fadeOut").toString())

                            FreezingVisual.show(args.get("player") as Player, args.get("title") as String, args.get("subtitle") as String, args.get("fadeIn") as Int, args.get("stay") as Int, args.get("fadeOut") as Int)
                            sender.sendMessage(Color.format(message))
                        } else {
                            // Show a fullscreen visual without timings
                            var message = LM.i().getLocale().shownVisuals.freezing_no_timings
                            message = message.replace("%prefix%", LM.i().getLocale().general.prefix)
                            message = message.replace("%target%", (args.get("player") as Player).name)
                            message = message.replace("%title%", args.get("title") as String)
                            message = message.replace("%subtitle%", args.get("subtitle") as String)

                            FreezingVisual.show(args.get("player") as Player, args.get("title") as String, args.get("subtitle") as String, Settings.i().timings.fadeIn, Settings.i().timings.stay, Settings.i().timings.fadeOut)
                            sender.sendMessage(Color.format(message))
                        }
                    })
                )
                .withSubcommand(CommandAPICommand("gradient")
                    .withSubcommand(CommandAPICommand("fullscreen")
                        .withArguments(noSelectorSuggestions)
                        .withArguments(TextArgument("text"))
                        .withArguments(AdventureChatColorArgument("color"))
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
                                message = message.replace("%target%", (args.get("player") as Player).name)
                                message = message.replace("%text%", args.get("text") as String)
                                message = message.replace("%fadeIn%", args.get("fadeIn").toString())
                                message = message.replace("%stay%", args.get("stay").toString())
                                message = message.replace("%fadeOut%", args.get("fadeOut").toString())

                                FullscreenGradientVisual.show(args.get("player") as Player, args.get("text") as String, "<${args.get("color")}>", args.get("fadeIn") as Int, args.get("stay") as Int, args.get("fadeOut") as Int)
                                sender.sendMessage(Color.format(message))
                            } else {
                                // Show a fullscreen visual without timings
                                var message = LM.i().getLocale().shownVisuals.fullscreen_gradient_no_timings
                                message = message.replace("%prefix%", LM.i().getLocale().general.prefix)
                                message = message.replace("%target%", (args.get("player") as Player).name)
                                message = message.replace("%text%", args.get("text") as String)

                                FullscreenGradientVisual.show(args.get("player") as Player, args.get("text") as String, "<${args.get("color")}>", Settings.i().timings.fadeIn, Settings.i().timings.stay, Settings.i().timings.fadeOut)
                                sender.sendMessage(Color.format(message))
                            }
                        })
                    )
                    .withSubcommand(CommandAPICommand("bottom")
                        .withArguments(noSelectorSuggestions)
                        .withArguments(TextArgument("title"))
                        .withArguments(TextArgument("subtitle"))
                        .withArguments(AdventureChatColorArgument("color"))
                        .withOptionalArguments(IntegerArgument("fadeIn"))
                        .withOptionalArguments(IntegerArgument("stay"))
                        .withOptionalArguments(IntegerArgument("fadeOut"))
                        .executes(CommandExecutor { sender, args ->
                            if (!Settings.i().visualToggles.gradient_bottom){
                                var message = LM.i().getLocale().general.thisVisualIsDisabled
                                message = message.replace("%prefix%", LM.i().getLocale().general.prefix)
                                sender.sendMessage(Color.format(message))
                                return@CommandExecutor
                            }
                            // Showing a full screen visual
                            if (args.get("fadeIn") != null && args.get("stay") != null && args.get("fadeOut") != null) {
                                // Show a fullscreen visual with timings
                                var message = LM.i().getLocale().shownVisuals.bottom_gradient_timings
                                message = message.replace("%prefix%", LM.i().getLocale().general.prefix)
                                message = message.replace("%target%", (args.get("player") as Player).name)
                                message = message.replace("%title%", args.get("title") as String)
                                message = message.replace("%subtitle%", args.get("subtitle") as String)
                                message = message.replace("%fadeIn%", args.get("fadeIn").toString())
                                message = message.replace("%stay%", args.get("stay").toString())
                                message = message.replace("%fadeOut%", args.get("fadeOut").toString())

                                BottomGradientVisual.show(args.get("player") as Player, args.get("title") as String, args.get("subtitle") as String, "<${args.get("color")}>", args.get("fadeIn") as Int, args.get("stay") as Int, args.get("fadeOut") as Int)
                                sender.sendMessage(Color.format(message))
                            } else {
                                // Show a fullscreen visual without timings
                                var message = LM.i().getLocale().shownVisuals.bottom_gradient_no_timings
                                message = message.replace("%prefix%", LM.i().getLocale().general.prefix)
                                message = message.replace("%target%", (args.get("player") as Player).name)
                                message = message.replace("%title%", args.get("title") as String)
                                message = message.replace("%subtitle%", args.get("subtitle") as String)

                                BottomGradientVisual.show(args.get("player") as Player, args.get("title") as String, args.get("subtitle") as String, "<${args.get("color")}>", Settings.i().timings.fadeIn, Settings.i().timings.stay, Settings.i().timings.fadeOut)
                                sender.sendMessage(Color.format(message))
                            }
                        })
                    )
                )
                .register()
        }
    }
}
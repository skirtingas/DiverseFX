package dev.skir.config

import de.exlll.configlib.*
import dev.skir.DiverseFX
import java.io.File
import java.nio.charset.StandardCharsets

@Configuration
class Settings {
    companion object {
        var instance: Settings? = null

        val CONFIG_HEADER: String = """
            DiverseFX settings file
            
            """.trimIndent()

        val PROPERTIES: YamlConfigurationProperties = YamlConfigurationProperties.newBuilder()
            .charset(StandardCharsets.UTF_8)
            .setNameFormatter(NameFormatters.LOWER_KEBAB_CASE)
            .header(CONFIG_HEADER).build()

        fun reload() {
            instance = YamlConfigurations.update(
                File(DiverseFX.instance.dataFolder, "settings.yml").toPath(),
                Settings::class.java, PROPERTIES
            )
        }

        fun i(): Settings {
            if (instance == null)
                instance = YamlConfigurations.update(
                    File(DiverseFX.instance.dataFolder, "settings.yml").toPath(),
                    Settings::class.java, PROPERTIES
                )
            return instance ?: Settings()
        }
    }
    @Comment("Language of the plugin")
    var language: String = "en_US"

    @Comment("After changing a command, you will need to restart the server for the changes to take effect.")
    var commands = Commands()
    @Configuration
    class Commands {
        @Comment("Command to show the visuals")
        var visual: String = "visual"
        @Comment("Command to reload the plugin")
        var diversefx: String = "diversefx"
    }

    var permissions = Permissions()
    @Configuration
    class Permissions{
        @Comment("Permission to use the command which shows the visuals")
        var visual_show: String = "kvisuals.visual"
        @Comment("Permission to reload the plugin")
        var diversefx_reload: String = "kvisuals.admin"
    }

    @Comment("Unicode symbols of the texture glyphs")
    var textureGlyphs = TextureGlyphs()
    @Configuration
    class TextureGlyphs {
        @Comment("Fullscreen Visual unicode")
        var fullscreen: String = "<glyph:visuals_fullscreen:colorable>"
        @Comment("Transparent Visual unicode")
        var transparent: String = "<glyph:visuals_transparent:colorable>"
        @Comment("Fullscreen Gradient Visual unicode")
        var gradient_fullscreen: String = "<glyph:visuals_gradient_fullscreen:colorable>"
    }

    @Comment("Toggle the visuals which you don't want to be used")
    var visualToggles = VisualToggles()
    @Configuration
    class VisualToggles {
        @Comment("Toggle the fullscreen visual")
        var fullscreen: Boolean = true
        @Comment("Toggle the transparent visual")
        var transparent: Boolean = true
        @Comment("Toggle the fullscreen gradient visual")
        var gradient_fullscreen: Boolean = true
        @Comment("Toggle the freezing visual")
        var freezing: Boolean = true
    }

    @Comment("Default settings for the visuals")
    var defaults = Defaults()
    @Configuration
    class Defaults {
        @Comment("Whether the visuals should freeze the player by default.")
        var freeze: Boolean = false

        @Comment("Default timings")
        var timings = Timings()
        @Configuration
        class Timings {
            @Comment("Default fadeIn time")
            var fadeIn: Int = 500
            @Comment("Default stay time")
            var stay: Int = 1760
            @Comment("Default fadeOut time")
            var fadeOut: Int = 500
        }
    }

    @Comment("Events that should be cancelled when the player is frozen")
    var freezeEvents = FreezeEvents()
    @Configuration
    class FreezeEvents {
        @Comment("Whether to make the player unable to move when the player is frozen")
        var cancelMove: Boolean = true
        @Comment("Whether to make the player unable to interact when the player is frozen")
        var cancelInteract: Boolean = true
        @Comment("Whether to make the player unable to chat when the player is frozen")
        var cancelChat: Boolean = true
        @Comment("Whether to unfreeze if the player quits while frozen")
        var unfreezeOnQuit: Boolean = true
    }
}
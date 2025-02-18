package net.starfal.config

import de.exlll.configlib.*
import net.starfal.kVisuals
import java.io.File
import java.nio.charset.StandardCharsets

@Configuration
class Settings {
    companion object {
        var instance: Settings? = null

        val CONFIG_HEADER: String = """
            kVisuals settings file
            
            """.trimIndent()

        val PROPERTIES: YamlConfigurationProperties = YamlConfigurationProperties.newBuilder()
            .charset(StandardCharsets.UTF_8)
            .setNameFormatter(NameFormatters.LOWER_KEBAB_CASE)
            .header(CONFIG_HEADER).build()

        fun reload() {
            instance = YamlConfigurations.update(
                File(kVisuals.instance.dataFolder, "settings.yml").toPath(),
                Settings::class.java, PROPERTIES
            )
        }

        fun i(): Settings {
            if (instance == null)
                instance = YamlConfigurations.update(
                    File(kVisuals.instance.dataFolder, "settings.yml").toPath(),
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
        var kvisuals: String = "kvisuals"
    }

    var permissions = Permissions()
    @Configuration
    class Permissions{
        @Comment("Permission to use the command which shows the visuals")
        var visual_show: String = "kvisuals.visual"
        @Comment("Permission to reload the plugin")
        var kvisuals_reload: String = "kvisuals.admin"
    }

    @Comment("Unicode symbols of the texture glyphs")
    var textureGlyphs = TextureGlyphs()
    @Configuration
    class TextureGlyphs {
        @Comment("Fullscreen Visual unicode")
        var fullscreen: String = ""
        @Comment("Transparent Visual unicode")
        var transparent: String = ""
        @Comment("Fullscreen Gradient Visual unicode")
        var gradient_fullscreen: String = ""
        @Comment("Bottom Gradient Visual unicode")
        var gradient_bottom: String = ""
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
        @Comment("Toggle the bottom gradient visual")
        var gradient_bottom: Boolean = true
        @Comment("Toggle the freezing visual")
        var freezing: Boolean = true
    }

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
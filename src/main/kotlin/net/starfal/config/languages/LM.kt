package net.starfal.config.languages

import net.starfal.config.Settings
import net.starfal.kVisuals
import java.io.File
import java.util.*
import java.util.concurrent.ConcurrentHashMap

class LM {
    companion object {
        var instance: LM? = null

        val FOLDER: File = File(kVisuals.instance.dataFolder, "languages")
        val DEFAULT: String = "en_US"


        fun i(): LM {
            if (instance == null) {
                instance = LM()
            }
            return instance as LM
        }
    }

    private val locales: MutableMap<String, Locale> = ConcurrentHashMap()


    init {
        if (!FOLDER.exists()) {
            FOLDER.mkdirs()
        }
        loadDefault()
        loadLocales()
    }

    fun getDefault(): Locale {
        return i().getOverride(DEFAULT)
            .orElseThrow { NullPointerException("Who removed the english locale?") }
    }

    fun loadLocales() {
        val files: Array<String> = checkNotNull(FOLDER.list())
        for (fileNames in files) {
            val name = fileNames.replace(".yml", "")
            val locale = Locale.get(name)
            locales[name] = locale
        }
    }

    fun loadDefault() {
        if (!File(FOLDER, "en_US.yml").exists()) {
            kVisuals.instance.saveResource("languages/en_US.yml", false)
        }
        if (!File(FOLDER, "lt_LT.yml").exists()) {
            kVisuals.instance.saveResource("languages/lt_LT.yml", false)
        }
    }
    fun getLocale(): Locale {
        val locale = locales[fix(Settings.i().language)]
            ?: return getOverride(DEFAULT).orElseThrow { NullPointerException("Who removed the english locale?") }
        return locale
    }
    fun reload() {
        locales.clear()
        loadLocales()
    }

    fun getOverride(localeName: String): Optional<Locale> {
        return Optional.ofNullable(locales[localeName])
    }

    fun getAll(): List<Locale> {
        return ArrayList(locales.values)
    }

    fun fix(localeName: String): String {
        val strings = localeName.split("_".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        return strings[0] + "_" + strings[1].uppercase(java.util.Locale.getDefault())
    }
}
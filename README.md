![kvisualsbanner](https://github.com/KITOXIS/kVisuals/assets/68541403/5b1771a3-09a8-4aac-ac86-7be26c0e03f3)

kVisuals is an Oraxen addon! Which means, that you will not be able to use this plugin without Oraxen. kVisuals is able to show unique visuals using a resourcepack from Oraxen. It automatically imports all of the necessary files to Oraxen, so you don't need to do unnecessary work! kVisuals documentation, has all of the features documented including a showcase for all of the visuals!

kVisuals uses 3 main syntaxes for the commands(all of them are in the option selector, aka tab completions):

"/visual" command with the simple options like transparent or fullscreen:
/visual <transparent:fullscreen> <player> <text> <color> <fadeIn> <stay> <fadeOut>

"/visual" command for the fullscreen gradient:
/visual gradient fullscreen <player> <text> <color> <fadeIn> <stay> <fadeOut>

"/visual" command for all of the other gradients:
/visual gradient <bottom:top:topandbottom> <player> <title> <subtitle> <color>

It also provides a config and an english messages file. Because of that it also provides another command "/kvisuals reload" to reload the configuration and the messages file.

To use spaces in text you can replace your spaces with "+" and the plugin will replace them to spaces!

It has 2 permissions:

- kvisuals.visual: lets you show visuals
- kvisuals.admin: does the same thing as the first permission, but also lets you reload the config. I am planning to make the permissions available to customize, but since I encountered a big bug, I will be fixing it in future updates! (For now if you want you can make different permissions in the configs, but they will go on top of the command permissions: if a player has kvisuals.admin and in the config you have set the admin permission as kvisuals.admincmd, if they do not have the kvisuals.admincmd permission, they will see the command in the command list, but when they try to run it, it will say that you do not have permission.)

Also there is 1 known bugs:

- Text being invisible, if using a title hud mod(where you can move the titles; I don't think I'm able to fix this.)
- When typing only /visual or /kvisuals it gives an error (I will fix it in future updates) and also when you type only /visual gradient. Fixed in 1.1
- !!!! 1.18.2 was tested, but the background was overlapping the text so if you are using 1.18.2, use the plugin at your own risk!

If you have questions, feel free to join our discord at https://starfal.net/discord Or check out the documentation at https://wiki.starfal.net/kvisuals!

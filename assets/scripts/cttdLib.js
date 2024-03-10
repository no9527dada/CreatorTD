


exports.modName = "cttd"

//读取JAVA文件
const urlLoader = Packages.java.net.URLClassLoader(
    [Vars.mods.getMod(modName).file.file().toURI().toURL()], Vars.mods.mainLoader()
    );
exports.getClass = function (name){
    return Packages.rhino.NativeJavaClass(Vars.mods.scripts.scope, urlLoader.loadClass(name));
}

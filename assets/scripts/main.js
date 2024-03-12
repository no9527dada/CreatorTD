//Java核心系统
function CreatorsPackage(name) {
 	var p = Packages.rhino.NativeJavaPackage(name, Vars.mods.mainLoader());
 	Packages.rhino.ScriptRuntime.setObjectProtoAndParent(p, Vars.mods.scripts.scope)
 	return p
 }
 
 var TDCreatorsJavaPack = CreatorsPackage('CreatorTowerDefense')
 importPackage(TDCreatorsJavaPack)
 importPackage(TDCreatorsJavaPack.content)
 //importPackage(TDCreatorsJavaPack.vv)



 CTTDModJS.RunName.add("cttd")
 CTTDModJS.DawnRun.add(run(() => {
	require("单位");

}));

package CreatorTowerDefense.content;

import arc.Core;
import arc.graphics.Color;
import arc.util.Align;
import arc.util.Time;
import mindustry.Vars;
import mindustry.ui.dialogs.BaseDialog;



public class CreatorTowerDefenseInfoDialog {
    public static BaseDialog hghghg;


    public static void show() {

        String QQ群2 = "https://jq.qq.com/?_wv=1027&k=oygqLbJ5";
        hghghg = new BaseDialog("warning") {
              String toText(String str) {
                return Core.bundle.format(str, new Object[0]);
            }
            private float leave = 8f * 60;
            private boolean canClose = false;

            {
                update(() -> {
                    leave -= Time.delta;
                    if (leave < 0 && !canClose) {
                        canClose = true;
                    }
                });
                buttons.button("", this::hide).update(b -> {
                    b.setDisabled(!canClose);
                    b.setText(canClose ? toText("close") : toText("close") + "[accent]" + Math.floor(leave / 60) + "[]s");
                }).size(140f, 50f).center();

                cont.pane((i -> {
                    i.add(Core.bundle.format("ct3tdZHUYI")).left().growX().wrap().width(620).maxWidth(620).pad(4).labelAlign(Align.left).row();
                    i.image().color(Color.valueOf("69dcee")).fillX().height(3).pad(3).row();
                    i.button(Core.bundle.format("QQ群2"), (() -> {
                        if (!Core.app.openURI(QQ群2)) {
                            Vars.ui.showErrorMessage("@linkfail");
                            Core.app.setClipboardText(QQ群2);
                        }
                    })).update(b -> b.color.fromHsv(Time.time % 360, 1, 1)).size(250.0f, 50).row();
                }));

            }
        };
        hghghg.show();
    }
}

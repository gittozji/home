/**
 * Created by imyu on 2017/5/9.
 */

/**
 * 表单清空，不包括disabled='disabled'以及type='hidden'的输入域
 * @param $webForm 表单jquery对象
 * @param webForm 表单webui对象
 */
function resetFormIgnoreDisabled($webForm, webForm) {
    var names = webForm.getNames();
    for(var i in names) {
        var name = names[i];
        var obj = $webForm.find("input[name='" + name + "']");
        if (obj.length < 1) {
            obj = $webForm.find("select[name='" + name+ "']");
        }
        if (obj.prop('type') != 'hidden' && obj.prop('disabled') != true) {
            webForm.setValue(name, "");
        }
    }
}
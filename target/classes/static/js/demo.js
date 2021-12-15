window.onload = function () {
  let hp_value = 45;
  let atk_value = 49;
  let def_value = 49;
  let spatk_value = 65;
  let spdef_value = 65;
  let speed_value = 45;

  document.getElementById("hp-value").innerHTML = hp_value;
  document.getElementById("atk-value").innerHTML = atk_value;
  document.getElementById("def-value").innerHTML = def_value;
  document.getElementById("spatk-value").innerHTML = spatk_value;
  document.getElementById("spdef-value").innerHTML = spdef_value;
  document.getElementById("speed-value").innerHTML = speed_value;

  document.getElementById("hp").value = hp_value;
  document.getElementById("atk").value = atk_value;
  document.getElementById("def").value = def_value;
  document.getElementById("spatk").value = spatk_value;
  document.getElementById("spdef").value = spdef_value;
  document.getElementById("speed").value = speed_value;

  let my_feature = "茂盛";
  let my_feature_desc = "这是茂盛特性的描述";

  $(function () {
    $("[data-toggle='feature']").popover({
      title: function () {
        return my_feature;
      },
      content: function () {
        return my_feature_desc;
      },
    });
  });
};

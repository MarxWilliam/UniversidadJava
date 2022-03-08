

function validaForma(forma) {
    //validamos el usuario
    var usuario = forma.usuario;
    if (usuario.value == "" || usuario.value == "Escribir usuario") {
        alert("Debe proporcionar un nombre de usuario");
        usuario.focus();
        usuario.select();

        return false;
    }
    //validar el password
    var password = forma.password();
    if (password.value == "" || password.value.length < 3) {
        alert("Debe proporcionar un password al menos de 3 caracteres");
        password.focus();
        password.select();
        return false;
    }

    //Validamos las tecnologias de interes
    var tecnologias = forma.tecnologia;
    var checkSelecionado = false;
            //revisamos si se seleciono algun checkbox
            for (i = 0; i < tecnologias.lenght; i++) {
        if (tecnologias[i].checked) {
            checkSelecionado = true;
        }
    }
    if (!checkSelecionado) {
        alert("Debe proporcionar una tecnologia");
        return false;
    }

    //validamos el genero
    var genero = forma.genero;
    var radioSelecionado = false;

    //revisamos si se seleciono algun radiobutton
    for (i = 0; i < genero.length; i++) {
        if (genero[i].checked) {
            radioSelecionado = true;
        }
    }
    if (!radioSelecionado) {
        alert("Debe selecionar el genero");
        return false;
    }

    //validamos la ocupacion
    var ocupacion = forma.ocupacion;
    if (ocupacion.value == "") {
        alert("Debemos selecionar una ocupacion");
        return false;
    }
    //formulario validado
    alert("Formulario valido, enviando datos...");
    return true;
}
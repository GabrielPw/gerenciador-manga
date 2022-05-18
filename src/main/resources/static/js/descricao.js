var editar = document.getElementById("editar").innerHTML;

if (editar == null){
    document.getElementById("editar").innerHTML = "Adicionar Descrição";
} else {
    document.getElementById("editar").innerHTML = "Editar Descrição";
}

function addDescricao()
{

    document.getElementById("form-desc").style.display = "block";
}

function salvarDescricao()
{
    var descricao = document.getElementById("textarea-descricao").value;
    document.getElementById("descricao").innerHTML = descricao;

    document.getElementById("form-desc").style.display = "none";
}

function cancelar()
{
    document.getElementById("form-desc").style.display = "none";

}
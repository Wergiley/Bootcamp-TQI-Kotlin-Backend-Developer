// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario
data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class FormacaoEducacional(val nome: String) {
    private val conteudos = mutableListOf<ConteudoEducacional>()
    private val inscritos = mutableListOf<Usuario>()

    fun adicionarConteudo(conteudo: ConteudoEducacional) {
        conteudos.add(conteudo)
    }

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }

    fun listarConteudos(): List<ConteudoEducacional> {
        return conteudos
    }

    fun listarInscritos(): List<Usuario> {
        return inscritos
    }
}

fun main() {
    // Criar usuários
    val usuario1 = Usuario("1", "João")
    val usuario2 = Usuario("2", "Maria")

    // Criar conteúdos educacionais
    val conteudo1 = ConteudoEducacional("Introdução à Programação", 120)
    val conteudo2 = ConteudoEducacional("Estruturas de Dados", 180)

    // Criar formação educacional
    val formacao = FormacaoEducacional("Ciência da Computação")
    formacao.adicionarConteudo(conteudo1)
    formacao.adicionarConteudo(conteudo2)

    // Matricular usuários na formação
    formacao.matricular(usuario1)
    formacao.matricular(usuario2)

    // Exibir informações da formação
    println("Formação: ${formacao.nome}")
    println("Conteúdos:")
    for (conteudo in formacao.listarConteudos()) {
        println("- ${conteudo.nome}")
    }
    println("Inscritos:")
    for (usuario in formacao.listarInscritos()) {
        println("- ${usuario.nome}")
    }
}

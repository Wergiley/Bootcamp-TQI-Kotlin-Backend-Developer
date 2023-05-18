/* Modelo de Exemplo
// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        TODO("Utilize o parâmetro $usuario para simular uma matrícula (usar a lista de $inscritos).")
    }
}

fun main() {
    TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")
}
*/

// Modelo 01 
enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: MutableList<ConteudoEducacional>) {
    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
}

fun main() {
    // Criação de usuários
    val usuario1 = Usuario("João")
    val usuario2 = Usuario("Maria")
    val usuario3 = Usuario("Pedro")

    // Criação de conteúdos educacionais
    val conteudo1 = ConteudoEducacional("Introdução à Programação", 120)
    val conteudo2 = ConteudoEducacional("Estruturas de Dados", 180)
    val conteudo3 = ConteudoEducacional("Programação Orientada a Objetos", 240)

    // Criação de formações
    val formacao1 = Formacao("Formação em Java", mutableListOf(conteudo1, conteudo2))
    val formacao2 = Formacao("Formação em Kotlin", mutableListOf(conteudo1, conteudo3))

    // Matrícula de usuários em formações
    formacao1.matricular(usuario1)
    formacao1.matricular(usuario2)
    formacao2.matricular(usuario3)

    // Impressão das informações das formações
    println("Formação: ${formacao1.nome}")
    println("Conteúdos: ${formacao1.conteudos.joinToString(", ") { it.nome }}")
    println("Inscritos: ${formacao1.inscritos.joinToString(", ") { it.nome }}")

    println()

    println("Formação: ${formacao2.nome}")
    println("Conteúdos: ${formacao2.conteudos.joinToString(", ") { it.nome }}")
    println("Inscritos: ${formacao2.inscritos.joinToString(", ") { it.nome }}")
}

// -----------------------------------------------------------------------------------------------------------------------------

// Modelo 02

// Classe abstrata para representar uma formação educacional
abstract class FormacaoEducacional(val nome: String, val cargaHoraria: Int) {
    abstract fun calcularValorHoraAula(): Double
    abstract fun calcularCustoTotal(): Double
}

// Classe para representar uma formação educacional de curso técnico
class CursoTecnico(
    nome: String,
    cargaHoraria: Int,
    val salarioInicial: Double,
    val duracaoMeses: Int
) : FormacaoEducacional(nome, cargaHoraria) {

    override fun calcularValorHoraAula(): Double {
        val horasAula = cargaHoraria / duracaoMeses / 4 // considerando 4 semanas por mês
        return salarioInicial / (horasAula * 40) // considerando 40 horas semanais
    }

    override fun calcularCustoTotal(): Double {
        return salarioInicial * duracaoMeses
    }
}

// Classe para representar uma formação educacional de graduação
class Graduacao(
    nome: String,
    cargaHoraria: Int,
    val mensalidade: Double,
    val duracaoAnos: Int
) : FormacaoEducacional(nome, cargaHoraria) {

    override fun calcularValorHoraAula(): Double {
        val totalHoras = cargaHoraria * duracaoAnos * 12 // considerando 12 meses por ano
        return mensalidade / totalHoras
    }

    override fun calcularCustoTotal(): Double {
        return mensalidade * duracaoAnos * 12 // considerando 12 meses por ano
    }
}

// Classe para representar uma formação educacional de pós-graduação
class PosGraduacao(
    nome: String,
    cargaHoraria: Int,
    val mensalidade: Double,
    val duracaoAnos: Int,
    val nivel: String
) : FormacaoEducacional(nome, cargaHoraria) {

    override fun calcularValorHoraAula(): Double {
        val totalHoras = cargaHoraria * duracaoAnos * 12 // considerando 12 meses por ano
        return mensalidade / totalHoras
    }

    override fun calcularCustoTotal(): Double {
        return mensalidade * duracaoAnos * 12 // considerando 12 meses por ano
    }
}

fun main() {
    val cursoTecnico = CursoTecnico("Técnico em Informática", 1200, 2000.0, 12)
    val graduacao = Graduacao("Ciência da Computação", 3000, 1500.0, 4)
    val posGraduacao = PosGraduacao("Mestrado em Engenharia de Software", 4000, 2500.0, 2, "Mestrado")

    val formacoes = listOf(cursoTecnico, graduacao, posGraduacao)

    for (formacao in formacoes) {
        println("Formação: ${formacao.nome}")
        println("Carga Horária: ${formacao.cargaHoraria} horas")

        val valorHoraAula = formacao.calcularValorHoraAula()
        println("Valor da Hora/Aula: R$ $valorHoraAula")

        val custoTotal = formacao.calcularCustoTotal()
        println("Custo Total


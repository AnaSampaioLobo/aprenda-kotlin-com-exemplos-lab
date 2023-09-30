enum class Nivel { BASICO, INTERMEDIARIO, AVANÇADO }

data class Usuario(val id: Long, val name: String)

data class ConteudoEducacional(val id: Long, var nome: String, val duracao: Int = 60)

data class Formacao(val id: Long, val nome: String, val nivel: Nivel, val conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        this.inscritos.add(usuario)
    }
}

fun main() {
   val anaUsuario = Usuario(1L, "Ana")
	val loboUsuario = Usuario(2L, "Lobo")

    val dockerConteudo = ConteudoEducacional(1L, "Docker Fundamentals", 120)
    val kubernetesConteudo = ConteudoEducacional(12, "Kubernetes Fundamentals", 180)
    val conteudos = listOf(dockerConteudo, kubernetesConteudo)

    val formacao = Formacao(1L, "DevOps Fundamentals", Nivel.AVANÇADO, conteudos)
    formacao.matricular(anaUsuario)
    formacao.matricular(loboUsuario)

    println("Formação: $formacao")
	println("Inscritos: ${formacao.inscritos}")
}

// Questão 1
class Produto {
    var nome: String
    var preco: Double
    // Implemente os construtores conforme especificado na questão
    constructor(nome:String, preco: Double){
        this.nome = nome
        this.preco = preco
    }
}

fun main() {
    // Crie instâncias das diferentes classes Produto utilizando os seus construtores e imprima os detalhes de cada produto.
    var produto1: Produto = Produto("PLAY1", 10.0)
    var produto2: Produto = Produto("SNES", 30.0)
    var produto3: Produto = Produto("MEGADRIVER", 6.0)
    println("Produto 1: ${produto1.nome}, Preço: ${produto1.preco}")
    println("Produto 2: ${produto2.nome}, Preço: ${produto2.preco}")
    println("Produto 3: ${produto3.nome}, Preço: ${produto3.preco}")
}

// Questão 2
class Cliente {
    var nome: String = ""

    private var idade: Int = 0

    // Utilize os modificadores de visibilidade para definir os atributos nome e idade conforme especificado na questão

    // Crie um método público na classe Cliente chamado mostrarIdade() conforme especificado na questão
    fun mostrarIdade() {
        println("Idade do cliente: $idade")
    }
}

fun main() {
    // Crie uma instância de Cliente e chame o método mostrarIdade() para verificar seu funcionamento.
    val cliente = Cliente()
    cliente.nome = "Pablo"
    cliente.mostrarIdade()
}

// Questão 3
abstract class Personagem {
    // Crie um método abstrato atacar() conforme especificado na questão
    abstract fun atacar()
}

class Guerreiro : Personagem() {
    override fun atacar() {
        // Implemente o método atacar() de acordo com as características do Guerreiro
        println("O guerreiro atacou com sua espada de duas mãos!")
    }
}

class Mago : Personagem() {
    override fun atacar() {
        // Implemente o método atacar() de acordo com as características do Mago
        println("O mago lançou mísseis mágicos!")
    }
}

fun main() {
    // Crie instâncias de Guerreiro e Mago e chame o método atacar() de cada um para verificar se estão realizando os ataques corretamente de acordo com suas respectivas classes.
    val guerreiroPablo = Guerreiro()
    val magoMatheus = Mago()

    guerreiroPablo.atacar()
    magoMatheus.atacar()
}

// Questão 4
interface FormaGeometrica {
    // Declare um método abstrato calcularArea() conforme especificado na questão
    fun calcularArea():Double

}

class Retangulo(val altura: Double, val largura: Double) : FormaGeometrica {
    override fun calcularArea(): Double {
        // Implemente o método calcularArea() para o Retangulo conforme especificado na questão
        return altura*largura
    }
}

class Circulo(val raio: Double) : FormaGeometrica {
    override fun calcularArea(): Double {
        // Implemente o método calcularArea() para o Circulo conforme especificado na questão
        return 2*raio*Math.PI
    }
}

fun main() {
    // Crie instâncias dessas duas classes e chame o método calcularArea() em cada uma delas para verificar o resultado.
    val retangulo = Retangulo(2.0, 3.0)
    val circulo = Circulo(2.5)

    println("Área do Retângulo é ${retangulo.calcularArea()} m²")
    println("Área do Círculo é ${circulo.calcularArea()} m²")
}

// Questão 5
class ContaBancaria {
    var numeroConta: String = ""
    var nomeTitular: String = ""

    // Implemente um getter personalizado para a propriedade nomeTitular conforme especificado na questão
    public var saldo: Double = 0.0
    // Implemente override do setter para o atributo saldo conforme especificado na questão
}

fun main() {
    // Crie uma instância de ContaBancaria. Altere o nome do titular para uma string que inicie com letra minúscula e mude o saldo para um valor negativo. Imprima os valores para verificar se as regras dos getters e setters estão sendo aplicadas corretamente.
    val conta = ContaBancaria()
    conta.numeroConta = "123456"
    conta.nomeTitular = "joão"
    conta.saldo = -100.0

    println("Número da Conta: ${conta.numeroConta}")
    println("Nome do Titular: ${conta.nomeTitular}")
    println("Saldo: ${conta.saldo}")
}

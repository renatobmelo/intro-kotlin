package br.ifpb.pdm

fun main() {
    val repositorioAnimal = RepositorioAnimal()
    var opcao = 5
    while (opcao != 11) {
        menu()
        print("Digite a opção: ")
        opcao = readlnOrNull()?.toInt() ?: 4
        when (opcao) {
            1 -> {
                println("Qual o Nome do Cachorro?")
                val nomeCachorro = readlnOrNull()?.toString() ?: ""
                println("Qual a Idade do Cachorro?")
                val idadeCachorro = readlnOrNull()?.toInt() ?: 0
                val cachorro = Cachorro(nomeCachorro ,idadeCachorro)
                repositorioAnimal.adicionar(cachorro)
            }
            2 -> {
                println("Qual o Nome do Gato?")
                val nomeGato = readlnOrNull()?.toString() ?: ""
                println("Qual o Idade do Gato?")
                val idadeGato = readlnOrNull()?.toInt() ?: 0
                val gato = Gato(nomeGato, idadeGato)
                repositorioAnimal.adicionar(gato)
            }
            3 -> {
                println("Qual o Nome do Pássaro?")
                val nomePassaro = readlnOrNull()?.toString() ?: ""
                println("Qual o Idade do Pássaro?")
                val idadePassaro = readlnOrNull()?.toInt() ?: 0
                val passaro = Passaro(nomePassaro, idadePassaro)
                repositorioAnimal.adicionar(passaro)
            }
            4 -> {
                println("Qual o Nome do Humano?")
                val nomeHumano = readlnOrNull()?.toString() ?: ""
                println("Qual o Idade do Humano?")
                val idadeHumano = readlnOrNull()?.toInt() ?: 0
                val Humano = Homem(nomeHumano, idadeHumano)
                repositorioAnimal.adicionar(Humano)
            }
            5 -> {
                repositorioAnimal.listar()
            }
            6 -> {
                repositorioAnimal.animais.forEach(Animal::emitirSom)
                repositorioAnimal.animais.forEach { it.emitirSom()}
            }
            7 -> {
                println("Digite o nome do animal que deseja excluir:")
                val nome = readlnOrNull()?.toString() ?: "";
                repositorioAnimal.remover(nome);
            }
            8 -> {
                println("Digite a cor dos animais que deseja visualizar:")
                val cor = readlnOrNull()?.toString() ?: "";
                repositorioAnimal.listarCor(cor).forEach{ println(it.nome) }
            }
            9 -> {
                println("Digite a idade dos animais que deseja visualizar:")
                val idade = readlnOrNull()?.toInt() ?: 0;
                repositorioAnimal.listarIdade(idade).forEach{ println(it.nome) }
            }
            10 -> {
                println("Digite o nome do Animal que deseja visualizar:")
                val procurarAnimal = readlnOrNull()?.toString() ?: "";
                val animalEncontrado = repositorioAnimal.buscarPorNome(procurarAnimal)
                println(animalEncontrado)
            }
        }

    }
}

abstract class Animal(var nome: String, var idade: Int, var cor: Cor) {

    abstract fun emitirSom()
    abstract fun idadeEmAnosHumanos()
}

class Cachorro(nome: String, idade: Int) : Animal(nome, idade, Cor.VERMELHO) {
    override fun emitirSom() {
        println("Au au")
    }

    override fun idadeEmAnosHumanos() {
        println(idade*7)
    }
}
class Gato(nome:String, idade: Int) : Animal(nome, idade, Cor.AZUL) {
    override fun emitirSom() {
        println("Miau")
    }
    override fun idadeEmAnosHumanos() {
        println(idade*7)
    }
}

class Passaro(nome:String, idade: Int) : Animal(nome, idade, Cor.VERDE) {
    override fun emitirSom() {
        println("Piu piu")
    }
    override fun idadeEmAnosHumanos() {
        println(idade*7)
    }
}

class Homem(nome:String, idade: Int) : Animal(nome, idade, Cor.AMARELO) {
    override fun emitirSom() {
        println("Olá")
    }
    override fun idadeEmAnosHumanos() {
        println(idade)
    }
}

fun menu() {
    println("1 - Cachorro")
    println("2 - Gato")
    println("3 - Pássaro")
    println("4 - Homens")
    println("5 - Listar Animais")
    println("6 - Emitir som")
    println("7 - Remover Animal")
    println("8 - Listar por cor")
    println("9 - Listar por idade")
    println("10 - Procurar animal pelo Nome")
    println("11 - Sair")
}

class RepositorioAnimal {
    val animais: MutableList<Animal> = mutableListOf()

    fun adicionar(animal: Animal) {
        animais.add(animal)
    }

    fun buscarPorNome(nome: String): String? {
        for (animal in animais) {
            if (animal.nome == nome) {
                return "Animal encontrado: ${animal.nome}, ${animal.idade}, ${animal.cor}"
            }
        }
        return "Animal não encontrado"
    }

    fun remover(nome: String) {
        var index: Int = 0;
        for (i in animais.withIndex()) {
            //println("${i.value} ${i.index} $index")
            if (i.value.nome == nome) {
                index = i.index;
            }
        }
        animais.removeAt(index);
    }
    fun listarCor(cor: String): MutableList<Animal> {
        var filtrados = mutableListOf<Animal>();
        for (animal in animais) {
            if (animal.cor.cor == cor) {
                filtrados.add(animal);
            }
        }
        return filtrados;
    }

    fun listarIdade(idade: Int): MutableList<Animal> {
        var filtrados = mutableListOf<Animal>();
        for (animal in animais) {
            if (animal.idade == idade) {
                filtrados.add(animal);
            }
        }
        return filtrados;
    }

    fun listar() {
        animais.forEach { println(it.nome) }
    }
}

enum class Cor(val cor: String) {
    VERMELHO("vermelho"),
    VERDE("verde"),
    AZUL("azul"),
    AMARELO("amarelo")
}
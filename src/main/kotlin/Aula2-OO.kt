package br.ifpb.pdm

fun main() {
    val repositorioAnimal = RepositorioAnimal()
    var opcao = 4
    while (opcao != 9) {
        menu()
        print("Digite a opção: ")
        opcao = readlnOrNull()?.toInt() ?: 4
        when (opcao) {
            1 -> {
                val cachorro = Cachorro(10)
                cachorro.nome = "Rex"
                repositorioAnimal.adicionar(cachorro)
            }
            2 -> {
                val gato = Gato(5)
                gato.nome = "Felix"
                repositorioAnimal.adicionar(gato)
            }
            3 -> {
                val passaro = Passaro(2)
                passaro.nome = "Piu"
                repositorioAnimal.adicionar(passaro)
            }
            4 -> {
                repositorioAnimal.listar()
            }
            5 -> {
                repositorioAnimal.animais.forEach(Animal::emitirSom)
                repositorioAnimal.animais.forEach { it.emitirSom()}
            }
            6 -> {
                println("Digite o nome do animal que deseja excluir:")
                val nome = readlnOrNull()?.toString() ?: "";
                repositorioAnimal.remover(nome);
            }
            7 -> {
                println("Digite a cor dos animais que deseja visualizar:")
                val cor = readlnOrNull()?.toString() ?: "";
                repositorioAnimal.listarCor(cor).forEach{ println(it.nome) }
            }
            8 -> {
                println("Digite a idade dos animais que deseja visualizar:")
                val idade = readlnOrNull()?.toInt() ?: 0;
                repositorioAnimal.listarIdade(idade).forEach{ println(it.nome) }
            }
        }

    }
}

abstract class Animal(var idade: Int, var cor: Cor) {
    open var nome: String = ""
        get() = "$field"
        set(valor) {
            field = valor
        }

    abstract fun emitirSom()
    abstract fun idadeEmAnosHumanos()
}

class Cachorro(idade: Int) : Animal(idade, Cor.VERMELHO) {
    override fun emitirSom() {
        println("Au au")
    }

    override fun idadeEmAnosHumanos() {
        println(idade*7)
    }
}
class Gato(idade: Int) : Animal(idade, Cor.AZUL) {
    override fun emitirSom() {
        println("Miau")
    }
    override fun idadeEmAnosHumanos() {
        println(idade*7)
    }
}

class Passaro(idade: Int) : Animal(idade, Cor.VERDE) {
    override fun emitirSom() {
        println("Piu piu")
    }
    override fun idadeEmAnosHumanos() {
        println(idade*7)
    }
}

fun menu() {
    println("1 - Cachorro")
    println("2 - Gato")
    println("3 - Pássaro")
    println("4 - Listar Animais")
    println("5 - Emitir som")
    println("6 - Remover Animal")
    println("7 - Listar por cor")
    println("8 - Listar por idade")
}

class RepositorioAnimal {
    val animais: MutableList<Animal> = mutableListOf()

    fun adicionar(animal: Animal) {
        animais.add(animal)
    }

    fun remover(nome: String) {
        var index: Int = 0;
        for (i in animais.withIndex()) {
            println("${i.value} ${i.index} $index")
            if (i.value.nome == nome) {
                index = i.index;
            }
        }
        animais.removeAt(index);

    }

    fun filtarNome()

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
    AZUL("azul")
}
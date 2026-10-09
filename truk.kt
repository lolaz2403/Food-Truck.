fun mostrarMenu() {
    println("\n===== FOOD TRUCK =====")
    println("1 - X-Burguer - R$ 15.00")
    println("2 - Cachorro-quente - R$ 10.00")
    println("3 - Batata frita - R$ 8.00")
    println("4 - Refrigerante - R$ 6.00")
    println("0 - Finalizar")
}

fun calcularDesconto(total: Double): Double {
    if (total >= 50) {
        return total * 0.10
    } else {
        return 0.0
    }
}

fun main() {

    print("Digite seu nome: ")
    val nome = readlnOrNull()?.trim() ?: "Cliente"

    var total = 0.0
    var quantidadeTotal = 0
    var continuar = true

    while (!continuar == false) {

        mostrarMenu()

        print("Escolha uma opção: ")
        val opcao = readlnOrNull()?.toIntOrNull() ?: -1

        if (opcao == 0) {
            continuar = false

        } else {

            var produto = ""
            var preco = 0.0

            when (opcao) {
                1 -> {
                    produto = "X-Burguer"
                    preco = 15.0
                }

                2 -> {
                    produto = "Cachorro-quente"
                    preco = 10.0
                }

                3 -> {
                    produto = "Batata frita"
                    preco = 8.0
                }

                4 -> {
                    produto = "Refrigerante"
                    preco = 6.0
                }

                else -> {
                    println("Opção inválida!")
                }
            }

            if (opcao >= 1 && opcao <= 4) {

                print("Digite a quantidade: ")
                val quantidade = readlnOrNull()?.toIntOrNull() ?: 0

                if (quantidade < 1 || quantidade > 10) {

                    println("Quantidade inválida!")

                } else {

                    val subtotal = preco * quantidade

                    total = total + subtotal
                    quantidadeTotal = quantidadeTotal + quantidade

                    println("$quantidade x $produto = R$ %.2f".format(subtotal))
                }
            }
        }
    }

    println("\n===== RESUMO =====")
    println("Cliente: $nome")
    println("Quantidade de produtos: $quantidadeTotal")
    println("Total: R$ %.2f".format(total))

    val desconto = calcularDesconto(total)
    val totalFinal = total - desconto

    println("Desconto: R$ %.2f".format(desconto))
    println("Total final: R$ %.2f".format(totalFinal))

    if (quantidadeTotal % 2 == 0) {
        println("Quantidade par de produtos.")
    } else {
        println("Quantidade ímpar de produtos.")
    }

    print("\nQuantas pessoas vão dividir a conta? ")
    val pessoas = readlnOrNull()?.toIntOrNull() ?: 1

    if (pessoas >= 2 && totalFinal > 0) {

        val valorPorPessoa = totalFinal / pessoas

        println("Cada pessoa pagará: R$ %.2f".format(valorPorPessoa))

    } else {
        println("A conta ficará para uma pessoa.")
    }

    println("Obrigado por comprar no Food Truck, $nome!")
}
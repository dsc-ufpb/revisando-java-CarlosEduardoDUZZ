# :wave: Programando em Java/OO 

## 🤓 Depois de tanto tempo longe de Java, está de volta, vamos revisar?

O objetivo desse lab é que vocês pensem nas classes e relacionamentos entre classes para um sistema simples, que é uma rede social de alunos para falarem das disciplinas. Usaremos Java como linguagem de desenvolvimento nesta disciplina, por isso é importante revisar conceitos 🚀

## :octocat: Git and GitHub

Usaremos o github classroom para os exercícios.

## Sistema de avaliação de disciplinas

Imagine que estamos criando o embrião de um sistema que é uma rede social de alunos para avaliar disciplinas de seu curso específico, por exemplo, sistemas de informação. No contexto dessa aplicação, uma Disciplina é uma classe que tem pelo menos os seguintes atributos: 
* id:int, nome:String, List<?> comentarios, likes:int e List<Double> notas.

Use Java para desenvolver as classes importantes para que esta aplicação tenha a seguinte funcionalidade:

* CRUD de usuários (nome, e-mail e senha);
* Login de um usuário: verifica se a senha/login estão ok;
* Adiciona a disciplina no sistema. Deve ser possível adicionar uma nova disciplina nesse sistema.
* Recupera todas as disciplinas inseridas no sistema.
* Atualiza o nome da disciplina com um determinado identificador id no sistema. Essa funcionalidade retorna a disciplina que foi atualizada.
* Adiciona mais uma nota à disciplina com um determinado identificador id no sistema. Retorna a nova nota (média) da disciplina.
* Adiciona um comentário a uma disciplina com identificador id no sistema. Cada comentário deve estar associado a apenas uma disciplina e deve ser possível identificar o usuário que escreveu o comentário e a data em que foi escrito. Retorna a disciplina atualizada com o novo comentário.
* Remove um comentário com um determinado identificador. Na verdade, um comentário não deve ser de fato removido, ele deve ser marcado como removido, e não deve mais ser inserido na resposta para o cliente.
* Remove a disciplina de identificador id do sistema e retorna a disciplina que foi removida. Ao remover a disciplina, remova também seus comentários.
* Recupera uma disciplina com um determinado identificador id (se esta disciplina estiver cadastrada). Apenas os comentários não removidos (logicamente) devem ser retornados.
* Retorna todas as disciplinas inseridas no sistema ordenadas pela nota média (da maior para a menor.

Pense em todas as possibilidades de erro em cada uma das funcionalidades e programe-se para elas. Use exceções sempre que necessário.

Requisitos de desenvolvimento:
* Use uma classe de fachada de controle para realizar cada uma das funcionalidades do sistema. Esta classe é a classe que a interface com o usuário conheceria... Os métodos desta classe são todos delegadores.
* A fachada deve conhecer serviços do sistema e os serviços conhecem os repositórios/gerentes de recursos do sistema:
  * Para cada recurso (usuário, disciplina) tenha classes que representam a coleção desse recurso, por exemplo, GerenteDeUsuários, GerenteDeDisciplinas (ou pode usar a palavra repositório em vez de gerente). Essas classes encapsulam coleções de um determinado tipo e são responsáveis pelo CRUD destes recursos.
* Os serviços que sabem realizar a operação que o usuário quer.
  * Por exemplo, para remover um comentário de um usuário é necessário receber as credenciais, verificar autenticidade do usuário, receber id do comentário a ser removido, verificar que o usuário que está solicitando é o dono do comentário pois cada usuário só pode remover seus próprios comentários. Esse serviço então deve conhecer não apenas o repositorio de usuários, mas também de disciplinas e comentários. A fachada fala com o serviço, que conhece os gerentes de recursos.
  * Você pode ter uma classe que funciona como serviço de cadastro de disciplinas, por exemplo. A fachada conhece esse serviço e solicita funcionalidades desse serviço. Assim, a fachada tem uma referência para um objeto desse serviço. Dentro do gerente/repositório de disciplinas existe a coleção de disciplinas e esse serviço de cadastro chama as operações de CRUD de disciplina dessa coleção.
* Pode usar sua criatividade para adicionar mais atributos às classes comentadas e mais funcionalidades ao sistema;
* Pode usar strategy para ter mais de um tipo de cálculo de nota das disciplinas:
  * Usar mediana;
  * Desconsiderar as 5% menores notas e as 5% maiores notas para o cálculo da média.

## 📚  Resources 
* [Material de Java básico](https://sites.google.com/dcx.ufpb.br/oo-java)
* [Git and GitHub learning resources](https://docs.github.com/en/github/getting-started-with-github/git-and-github-learning-resources) 

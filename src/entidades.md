# Entidades a serem atribuídas para o sistema de notificação de agravos

1. Notificações - deverão ser cadastradas notificações cuja as informações deverão incluir as seguintes sub-classes:

- Dados gerais:
    - Agravo/doença: MALÁRIA 
    - Data da Notificação 
    - UF 
    - Município de Notificação 
    - Unidade de Saúde (ou outra fonte notificadora) 
    - Data dos Primeiros Sintomas 


- Dados individuais:
    - Nome do paciente 
    - Data de Nascimento 
    - Idade 
    - Sexo -> Enum {M: Masculino, F: Feminino} 
    - Gestante -> Enum {1: 1° Trimestre, 2: 2°Trimestre, 3: 3 Trimestre, 4: Idade gestacional Ignorada, 5: Não, 6: Não se aplica} 
    - Raça/Cor -> Enum {1: Branca, 2: Preta, 3: Amarela, 4: Parda, 5: Indigena, 9: Ignorado} 
    - Escolaridade -> Enum {0: Analfabeto, 1: 1ª a 4ª série incompleta do EF, 2: 4ª série completa do EF, 3: 5ª à 8ª série incompleta do EF, 4: Ensino fundamental completo, 5: Ensino médio incompleto, 6: Ensino médio completo, 7: Educação superior incompleta, 8: Educação superior completa, 9: Ignorado, 10: Não se aplica} 
    - Número do Cartão SUS 
    - Nome da mãe 


- Dados residenciais: 
    - UF 
    - Município de Residência 
    - Distrito 
    - Bairro 
    - Logradouro (rua, avenida,...) 
    - Número 
    - CEP 
    - (DDD) Telefone 
    - Zona -> Enum {1: Urbana, 2: Rural, 3: Periurbana, 9: Ignorado} 


- Dados complementares e epidemiológicos: 
    - Data da Investigação 
    - Ocupação 
    - Principal Atividade nos Últimos 15 Dias -> Enum {1: Agricultura, 2: Pecuária, 3: Doméstica, 4: Turismo, 5: Garimpagem, 6: Exploração vegetal, 7: Caça/pesca, 8: const.estrad.barragens, 9: Mineração, 10: Viajante, 11: Outros, 12: Motorista} 
    - Dados do exame: 
    - Tipo de lâmina -> Enum {1: BP, 2: BA, 3: LVC, 99: Ignorado} 
    - Sintomas -> Enum {1: Com sintomas, 2: Sem sintomas} 
    - Data do Exame 
    - Resultado do Exame -> Enum {1: Negativo, 2: F, 3: F+FG, 4: V, 5: F+V, 6: V+FG, 7: FG, 8: M, 9: F+M, 10: O} 
    - Parasitos por mm³ 
    - Parasitemia em "cruzes" -> Enum {1: <+/2 (menor que meia cruz), 2: +/2 (meia cuz), 3: + (uma cruz), 4: ++ (duas cruzes), 5: +++ (três cruzes), 6: ++++ (quatro cruzes)} 


- Dados do tratamento: 
    - Esquema de tratamento utilizado -> Enum {1: Infecções por Pv com Cloroquina em 3 dias e Primaquina em 7 dias, 2: Infecções por Pf com Quinina em 3 dias + Doxiciclina em 5 dias + primaquina no 6º dia, 3: Infecções mistas por Pv + Pf com Mefloquina em dose única e primaquina em 7 dias, 4: Infecções por Pm com cloroquina em 3 dias, 5: Infecções por Pv em crianças apresentando vômitos..., 6: Infecções por Pf com Mefloquina em dose única e prímaquina no segundo dia, 7: Infecções por Pf com Quinina em 7 dias, 8: Infecções por Pf de crianças com cápsulas retais de artesunato..., 9: Infecções mistas por Pv + Pf com Quinina em 3 dias..., 10: Prevenção de recaída da malária por Pv..., 11: Malária grave e complicada, 12: Infecções por Pf com a associação Artemeter+Lumerfantrina..., 99: Outro esquema utilizado} 
    - Data Início do Tratamento 

- Conclusão e encerramento: 
    - Classificação Final -> Enum {1: Confirmado, 2: Descartado} 
    - O caso é autóctone do município de residência? -> Enum {1: Sim, 2: Não, 3: Indeterminado} 
    - UF provável de infecção 
    - País provável de infecção 
    - Município provável da infecção 
    - Localidade provável da infecção 
    - Data de Encerramento 
    - Matricula e nome do examinador

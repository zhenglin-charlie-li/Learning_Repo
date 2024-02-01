accounts = {}
outgoing_amounts = {}
res = []


def solution(queries):
    for query in queries:
        action = query[0]

        if action == "CREATE_ACCOUNT":
            res.append(create_account(query[1], query[2]))
        elif action == "DEPOSIT":
            res.append(deposit(query[1], query[2], query[3]))
        elif action == "TRANSFER":
            res.append(transfer(query[1], query[2], query[3], query[4]))
        elif action == "TOP_SPENDERS":
            res.append(top_spenders(query[1], query[2]))
    return res


def create_account(timestamp, account_id):
    if account_id in accounts:
        return "false"
    else:
        accounts[account_id] = 0
        outgoing_amounts[account_id] = 0
        return "true"


def deposit(timestamp, account_id, amount):
    if account_id not in accounts:
        return ""

    accounts[account_id] += int(amount)
    return str(accounts[account_id])


def transfer(timestamp, source_account_id, target_account_id, amount):
    amount = int(amount)
    if source_account_id not in accounts or target_account_id not in accounts:
        return ""

    if source_account_id == target_account_id or accounts[source_account_id] < amount:
        return ""

    accounts[source_account_id] -= amount
    accounts[target_account_id] += amount
    outgoing_amounts[source_account_id] += amount  # update outgoing amount for source account

    return str(accounts[source_account_id])


def top_spenders(timestamp, n):
    # Sort based on outgoing amount and then by account_id
    sorted_accounts = sorted(outgoing_amounts.items(), key=lambda x: (-x[1], x[0]))

    # Extract top n accounts
    top_accounts = sorted_accounts[:int(n)]

    # Convert to the desired string format
    result = ", ".join([f"{account[0]}({account[1]})" for account in top_accounts])

    return result


queries = [["CREATE_ACCOUNT","1","account1"],
 ["DEPOSIT","2","account1","1000"],
 ["SCHEDULE_PAYMENT","3","account1","300","10"],
 ["DEPOSIT","12","account1","10"],
 ["DEPOSIT","13","account1","10"]]

print(solution(queries))
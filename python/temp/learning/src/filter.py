def odd(list):
    if(type(list) != type([])):
        raise TypeError, "Expected a list type. but got %s" % type(list)
    
    return filter(lambda f: f % 2 == 1, list)
    
print odd([1, 2, 3, 4, 5])


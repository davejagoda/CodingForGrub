#!/usr/bin/python

# by Dave Jagoda
# bibliography:
# http://docs.python.org/howto/unicode.html
# tested with Python2 on Linux and OS X

import sys, unicodedata, codecs

def getUnicodeData(codePoint):
    c = unichr(codePoint)
    try:
        n = unicodedata.name(c)
    except:
        n = ''
    return(c + ' ' + n)

if len(sys.argv) == 2:
    filename = sys.argv[1]
else:
    print 'usage: ' + sys.argv[0] + ' <file to create with utf8 data>'
    sys.exit(1)

f = codecs.open(filename, encoding='utf-8', mode='w')
for i in range(0x10000):
    ret = getUnicodeData(i)
    o = '%04x %s\n' % (i, ret)
    f.write(o)
f.close()

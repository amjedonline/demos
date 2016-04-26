# coding: utf-8
from pycassa.system_manager import *
sys=SystemManager('localhost:9160')
sys.create_keyspace('blog_ks', SIMPLE_STRATEGY, {'replication_factor':'1'});
sys.create_column_family('blog_ks', 'blog_md', comparator_type=UTF8_TYPE, key_validation_class=UTF8_TYPE);
sys.alter_column('blog_ks','blog_md', 'name', UTF8_TYPE);
sys.alter_column('blog_ks','blog_md', 'email', UTF8_TYPE);
sys.alter_column('blog_ks','blog_md', 'password', UTF8_TYPE);
cf_kwargs0= {'key_validation_class':TIME_UUID_TYPE, 'comparator_type': UTF8_TYPE} 
sys.create_column_family('blog_ks', 'posts', **cf_kwargs0)
sys.alter_column('blog_ks','posts', 'title', UTF8_TYPE)
sys.alter_column('blog_ks','posts', 'text', UTF8_TYPE)
sys.alter_column('blog_ks','posts', 'blog_name', UTF8_TYPE)
sys.alter_column('blog_ks','posts', 'author_name', UTF8_TYPE)
sys.alter_column('blog_ks','posts', 'timestamp', DATE_TYPE)
sys.create_column_family('blog_ks', 'comments', **cf_kwargs0)
sys.alter_column('blog_ks','comments', 'comment', UTF8_TYPE)
sys.alter_column('blog_ks','comments', 'author', UTF8_TYPE)
sys.alter_column('blog_ks','comments', 'timestamp', DATE_TYPE)
cf_kwargs1={'compatator_type':LONG_TYPE, 'default_validation_class':TIME_UUID_TYPE, 'key_validation_class': UTF8_TYPE}
cf_kwargs2={'compatator_type':LONG_TYPE, 'default_validation_class':TIME_UUID_TYPE, 'key_validation_class': TIME_UUID_TYPE}
sys.create_column_family('blog_ks', 'blog_posts', **cf_kwargs1);
sys.create_column_family('blog_ks', 'post_comments', **cf_kwargs2);

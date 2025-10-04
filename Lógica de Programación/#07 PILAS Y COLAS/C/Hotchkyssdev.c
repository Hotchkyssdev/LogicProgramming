/* EJERCICIO:
 * Implementa los mecanismos de introducción y recuperación de elementos propios de las
 * pilas (stacks - LIFO) y las colas (queue - FIFO) utilizando una estructura de array
 * o lista (dependiendo de las posibilidades de tu lenguaje).
 *
 * DIFICULTAD EXTRA (opcional):
 * - Utilizando la implementación de pila y cadenas de texto, simula el mecanismo adelante/atrás
 *   de un navegador web. Crea un programa en el que puedas navegar a una página o indicarle
 *   que te quieres desplazar adelante o atrás, mostrando en cada caso el nombre de la web.
 *   Las palabras "adelante", "atrás" desencadenan esta acción, el resto se interpreta como
 *   el nombre de una nueva web.
 * - Utilizando la implementación de cola y cadenas de texto, simula el mecanismo de una
 *   impresora compartida que recibe documentos y los imprime cuando así se le indica.
 *   La palabra "imprimir" imprime un elemento de la cola, el resto de palabras se
 *   interpretan como nombres de documentos.
 */
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <limits.h>
#include <ctype.h>
#define MAX_STACK 100
#define MAX_QUEUE 100
#define MAX_DEQUE 100
#define MAX_VERTICES 20
#define HASH_SIZE 11

/* ---------- Listas enlazadas ---------- */
/* Lista simple */
typedef struct SNode {
    int val;
    struct SNode *next;
} SNode;
SNode* s_insert_front(SNode *head, int v);
SNode* s_insert_end(SNode *head, int v);
SNode* s_delete_val(SNode *head, int v);
SNode* s_search(SNode *head, int v);
void s_print(SNode *head);
void s_free(SNode *head);

/* Lista doble */
typedef struct DNode {
    int val;
    struct DNode *prev, *next;
} DNode;
DNode* d_insert_end(DNode *tail_ref, int v); //Retorna nueva cola
DNode* d_delete_val(DNode *head, int v);     //Retorna nueva cabeza
void d_print_forward(DNode *head);
void d_print_backward(DNode *tail);
void d_free(DNode *head);

/* Lista circular simple */
typedef struct CNode {
    int val;
    struct CNode *next;
} CNode;
CNode* cs_insert_end(CNode *tail, int v); //Puntero de la cola usado para la lista circular
CNode* cs_delete_val(CNode *tail, int v);
void cs_print(CNode *tail);
void cs_free(CNode *tail);

/* Lista circular doble */
typedef struct CDNode {
    int val;
    struct CDNode *prev, *next;
} CDNode;
CDNode* cd_insert_end(CDNode *tail, int v); //Puntero de la cola
CDNode* cd_delete_val(CDNode *tail, int v);
void cd_print(CDNode *tail);
void cd_free(CDNode *tail);

/* ---------- Pilas (stacks) ---------- */
//Stack del arreglo
typedef struct {
    int data[MAX_STACK];
    int top;
} ArrayStack;
void astack_init(ArrayStack *s);
int astack_push(ArrayStack *s, int v);
int astack_pop(ArrayStack *s, int *out);
void astack_print(ArrayStack *s);

//Stack de la Lista Enlazada
typedef struct LNode {
    int val;
    struct LNode *next;
} LNode;
LNode* lstack_push(LNode *head, int v); //Retorna la nueva cabeza
LNode* lstack_pop(LNode *head, int *out); //Retorna la nueva cabeza
void lstack_print(LNode *head);
void lstack_free(LNode *head);

/* ---------- Colas (queues) ---------- */
//Cola simple usando lista enlazada
typedef struct QNode {
    int val;
    struct QNode *next;
} QNode;
typedef struct {
    QNode *front, *rear;
} SimpleQueue;
void sq_init(SimpleQueue *q);
int sq_enqueue(SimpleQueue *q, int v);
int sq_dequeue(SimpleQueue *q, int *out);
void sq_print(SimpleQueue *q);
void sq_free(SimpleQueue *q);

//Cola circular usando arreglo
typedef struct {
    int data[MAX_QUEUE];
    int front, rear, size;
} CircQueue;
void cq_init(CircQueue *q);
int cq_enqueue(CircQueue *q, int v);
int cq_dequeue(CircQueue *q, int *out);
void cq_print(CircQueue *q);

//Desencolado usando  arreglo
typedef struct {
    int data[MAX_DEQUE];
    int front, rear, size;
} Deque;
void dq_init(Deque *d);
int dq_push_front(Deque *d, int v);
int dq_push_back(Deque *d, int v);
int dq_pop_front(Deque *d, int *out);
int dq_pop_back(Deque *d, int *out);
void dq_print(Deque *d);

//Cola prioritaria simple (min-heap) usando arreglo
typedef struct {
    int data[MAX_QUEUE];
    int size;
} MinHeap;
void heap_init(MinHeap *h);
int heap_push(MinHeap *h, int v);
int heap_pop(MinHeap *h, int *out);
void heap_print(MinHeap *h);

/* ---------- Árboles ---------- */
//Árbol binario genérico y BST (nodos con punteros izquierdo/derecho)
typedef struct TNode {
    int val;
    struct TNode *left, *right;
} TNode;
TNode* tnode_new(int v);
TNode* bst_insert(TNode *root, int v);
TNode* bst_search(TNode *root, int v);
TNode* bst_delete(TNode *root, int v);
TNode* bst_find_min(TNode *root);
void bst_inorder(TNode *root);
void bst_preorder(TNode *root);
void bst_postorder(TNode *root);
void bst_free(TNode *root);

/* ---------- Grafos ---------- */
//Matriz de adyacencia
typedef struct {
    int n;
    int mat[MAX_VERTICES][MAX_VERTICES];
} AdjMatrix;
void am_init(AdjMatrix *g, int n);
void am_add_edge(AdjMatrix *g, int u, int v, int directed);
void am_remove_edge(AdjMatrix *g, int u, int v, int directed);
void am_print(AdjMatrix *g);

//Lista de adyacencia (array de listas)
typedef struct GAdjNode {
    int v;
    struct GAdjNode *next;
} GAdjNode;
typedef struct {
    int n;
    GAdjNode *heads[MAX_VERTICES];
} AdjList;
void al_init(AdjList *g, int n);
void al_add_edge(AdjList *g, int u, int v, int directed);
void al_remove_edge(AdjList *g, int u, int v, int directed);
void al_print(AdjList *g);
void al_free(AdjList *g);

/* ---------- Tabla hash (encadenamiento) ---------- */
typedef struct HNode {
    int key;
    struct HNode *next;
} HNode;
typedef struct {
    HNode *buckets[HASH_SIZE];
} HashTable;
int hash_func(int key);
void ht_init(HashTable *ht);
void ht_insert(HashTable *ht, int key);
int ht_search(HashTable *ht, int key);
void ht_delete(HashTable *ht, int key);
void ht_print(HashTable *ht);
void ht_free(HashTable *ht);

/* ---------------------- IMPLEMENTACIONES ---------------------- */
/* ---------- Listas enlazadas simple ---------- */
SNode* s_insert_front(SNode *head, int v) {
    SNode *n = malloc(sizeof(SNode));
    if (!n) {
        return head;
    }
    n->val = v; 
    n->next = head;
    return n;
}

SNode* s_insert_end(SNode *head, int v) {
    SNode *n = malloc(sizeof(SNode));
    if (!n) {
        return head;
    }
    n->val = v; 
    n->next = NULL;

    if (!head) {
        return n;
    }

    SNode *it = head;
    while (it->next) {
        it = it->next;
    }
    it->next = n;
    return head;
}

SNode* s_delete_val(SNode *head, int v) {
    SNode dummy; dummy.next = head;
    SNode *prev = &dummy;
    SNode *it = head;
    while (it) {
        if (it->val == v) {
            prev->next = it->next;
            free(it);
            break;
        }
        prev = it; 
        it = it->next;
    }
    return dummy.next;
}

SNode* s_search(SNode *head, int v) {
    for (SNode *it = head; it; it = it->next) {
        if (it->val == v) {
            return it;
        }
    }
    return NULL;
}

void s_print(SNode *head) {
    printf("[");
    for (SNode *it = head; it; it = it->next) {
        printf("%d", it->val);
        if (it->next) printf(", ");
    }
    printf("]\n");
}

void s_free(SNode *head) {
    while (head) {
        SNode *t = head->next; free(head); head = t;
    }
}

/* ---------- Lista doble ---------- */
DNode* d_insert_end(DNode *tail_ref, int v) {
    DNode *n = malloc(sizeof(DNode));
    if (!n) {
        return tail_ref;
    }
    n->val = v; 
    n->next = NULL; 
    n->prev = NULL;

    if (!tail_ref) {
        return n; /* empty: tail is also head */
    }
    DNode *head = tail_ref;

    while (head && head->prev) {
        head = head->prev; /* find head */
    }
    /* append to tail_ref */
    tail_ref->next = n;
    n->prev = tail_ref;
    return n; /* new tail */
}

DNode* d_delete_val(DNode *head, int v) {
    if (!head) {
        return NULL;
    }
    /* find head */
    DNode *h = head;
    while (h->prev) {
        h = h->prev;
    }

    DNode *it = h;
    while (it) {
        if (it->val == v) {
            if (it->prev) {
                it->prev->next = it->next;
            }

            if (it->next) {
                it->next->prev = it->prev;
            }

            DNode *new_head = h;
            if (it == h) {
                new_head = it->next;
            }
            free(it);
            /* return pointer that was used originally (some tail or head); for simplicity return new_head */
            return new_head;
        }
        it = it->next;
    }
    return h;
}

void d_print_forward(DNode *head) {
    if (!head) { 
        printf("[]\n"); 
        return; 
    }

    while (head->prev) {
        head = head->prev;
    }

    printf("[");
    DNode *it = head;
    while (it) {
        printf("%d", it->val);
        if (it->next) {
            printf(", ");
        }
        it = it->next;
    }
    printf("]\n");
}

void d_print_backward(DNode *tail) {
    if (!tail) { 
        printf("[]\n"); 
        return; 
    
    }

    while (tail->next) {
        tail = tail->next;
    }

    printf("[");
    DNode *it = tail;
    while (it) {
        printf("%d", it->val);
        if (it->prev) {
            printf(", ");
        }
        it = it->prev;
    }
    printf("]\n");
}

void d_free(DNode *head) {
    if (!head) {
        return;
    }

    while (head->prev) {
        head = head->prev;
    }

    while (head) {
        DNode *t = head->next; 
        free(head); 
        head = t;
    }
}

/* ---------- Circular simple ---------- */
CNode* cs_insert_end(CNode *tail, int v) {
    CNode *n = malloc(sizeof(CNode));
    if (!n) {
        return tail;
    }
    n->val = v;

    if (!tail) {
        n->next = n;
        return n;
    }
    n->next = tail->next;
    tail->next = n;

    return n;
}

CNode* cs_delete_val(CNode *tail, int v) {
    if (!tail) {
        return NULL;
    }

    CNode *cur = tail->next, *prev = tail;
    do {
        if (cur->val == v) {
            if (cur == prev) { /* only one node */
                free(cur);
                return NULL;
            }
            prev->next = cur->next;
            if (cur == tail) {
                tail = prev;
            }
            free(cur);
            return tail;
        }
        prev = cur; 
        cur = cur->next;
    } while (cur != tail->next);

    return tail;
}

void cs_print(CNode *tail) {
    if (!tail) { 
        printf("[]\n"); 
        return; 
    }

    CNode *it = tail->next;
    printf("[");
    do {
        printf("%d", it->val);
        it = it->next;
        if (it != tail->next) {
            printf(", ");
        }
    } while (it != tail->next);
    printf("]\n");
}

void cs_free(CNode *tail) {
    if (!tail) {
        return;
    }

    CNode *start = tail->next;
    CNode *it = start->next;
    while (it != start) {
        CNode *t = it->next; 
        free(it); 
        it = t;
    }
    free(start);
}

/* ---------- Circular doble ---------- */
CDNode* cd_insert_end(CDNode *tail, int v) {
    CDNode *n = malloc(sizeof(CDNode));
    if (!n) {
        return tail;
    }
    n->val = v;

    if (!tail) {
        n->next = n->prev = n;
        return n;
    }

    CDNode *head = tail->next;
    n->next = head;
    n->prev = tail;
    tail->next = n;
    head->prev = n;

    return n;
}

CDNode* cd_delete_val(CDNode *tail, int v) {
    if (!tail) {
        return NULL;
    }

    CDNode *it = tail->next;
    CDNode *start = it;
    do {
        if (it->val == v) {
            if (it->next == it) { 
                free(it); 
                return NULL; 
            }
            it->prev->next = it->next;
            it->next->prev = it->prev;

            if (it == tail) {
                tail = it->prev;
            }

            if (it == start) {
                start = it->next;
            }

            free(it);
            return tail;
        }
        it = it->next;
    } while (it != start);

    return tail;
}

void cd_print(CDNode *tail) {
    if (!tail) { 
        printf("[]\n"); 
        return; 
    }

    CDNode *it = tail->next;
    printf("[");
    CDNode *start = it;
    do {
        printf("%d", it->val);
        it = it->next;
        if (it != start) {
            printf(", ");
        }
    } while (it != start);
    printf("]\n");
}

void cd_free(CDNode *tail) {
    if (!tail) {
        return;
    }
    CDNode *start = tail->next;
    CDNode *it = start->next;

    while (it != start) { 
        CDNode *t = it->next; 
        free(it); 
        it = t; 
    }
    free(start);
}

/* ---------- Pilas (arreglo) ---------- */
void astack_init(ArrayStack *s) { 
    s->top = -1; 
}

int astack_push(ArrayStack *s, int v) {
    if (s->top >= MAX_STACK-1) {
        return 0;
    }
    s->data[++s->top] = v; 

    return 1;
}

int astack_pop(ArrayStack *s, int *out) {
    if (s->top < 0) {
        return 0;
    }
    *out = s->data[s->top--]; 

    return 1;
}

void astack_print(ArrayStack *s) {
    printf("[");
    for (int i = 0; i <= s->top; ++i) {
        printf("%d", s->data[i]);
        if (i < s->top) {
            printf(", ");
        }
    }
    printf("]\n");
}

/* ---------- Pilas (lista) ---------- */
LNode* lstack_push(LNode *head, int v) {
    LNode *n = malloc(sizeof(LNode));
    if (!n) {
        return head;
    }
    n->val = v; 
    n->next = head; 

    return n;
}

LNode* lstack_pop(LNode *head, int *out) {
    if (!head) {
        return NULL;
    }
    *out = head->val;
    LNode *nx = head->next;
    free(head);

    return nx;
}

void lstack_print(LNode *head) {
    printf("[");
    for (LNode *it = head; it; it = it->next) {
        printf("%d", it->val);
        if (it->next) {
            printf(", ");
        }
    }
    printf("]\n");
}

void lstack_free(LNode *head) { 
    while (head) { 
        LNode *t = head->next; 
        free(head); 
        head = t; 
    } 
}

/* ---------- Cola simple (lista) ---------- */
void sq_init(SimpleQueue *q) { 
    q->front = q->rear = NULL; 
}

int sq_enqueue(SimpleQueue *q, int v) {
    QNode *n = malloc(sizeof(QNode));
    if (!n) {
        return 0;
    }
    n->val = v; 
    n->next = NULL;

    if (!q->rear) {
        q->front = q->rear = n;
    } else { 
        q->rear->next = n; 
        q->rear = n; 
    }

    return 1;
}

int sq_dequeue(SimpleQueue *q, int *out) {
    if (!q->front) {
        return 0;
    }
    QNode *t = q->front;
    *out = t->val;
    q->front = t->next;

    if (!q->front) {
        q->rear = NULL;
    }
    free(t);

    return 1;
}

void sq_print(SimpleQueue *q) {
    printf("[");
    for (QNode *it = q->front; it; it = it->next) {
        printf("%d", it->val);
        if (it->next) {
            printf(", ");
        }
    }
    printf("]\n");
}

void sq_free(SimpleQueue *q) { 
    int tmp; 
    while (sq_dequeue(q, &tmp)); 
}

/* ---------- Cola circular (array) ---------- */
void cq_init(CircQueue *q) { 
    q->front = 0; 
    q->rear = -1; 
    q->size = 0; 
}

int cq_enqueue(CircQueue *q, int v) {
    if (q->size >= MAX_QUEUE) {
        return 0;
    }
    q->rear = (q->rear + 1) % MAX_QUEUE;
    q->data[q->rear] = v;
    q->size++;

    return 1;
}

int cq_dequeue(CircQueue *q, int *out) {
    if (q->size == 0) {
        return 0;
    }
    *out = q->data[q->front];
    q->front = (q->front + 1) % MAX_QUEUE;
    q->size--;

    return 1;
}

void cq_print(CircQueue *q) {
    printf("[");
    for (int i = 0; i < q->size; ++i) {
        int idx = (q->front + i) % MAX_QUEUE;
        printf("%d", q->data[idx]);

        if (i < q->size-1) {
            printf(", ");
        }
    }
    printf("]\n");
}

/* ---------- Deque (array) ---------- */
void dq_init(Deque *d) { 
    d->front = 0; 
    d->rear = -1; 
    d->size = 0; 
}

int dq_push_front(Deque *d, int v) {
    if (d->size >= MAX_DEQUE) {
        return 0;
    }
    d->front = (d->front - 1 + MAX_DEQUE) % MAX_DEQUE;
    d->data[d->front] = v;
    d->size++;

    return 1;
}

int dq_push_back(Deque *d, int v) {
    if (d->size >= MAX_DEQUE) {
        return 0;
    }
    d->rear = (d->rear + 1) % MAX_DEQUE;
    d->data[d->rear] = v;
    d->size++;

    return 1;
}

int dq_pop_front(Deque *d, int *out) {
    if (d->size == 0) {
        return 0;
    }
    *out = d->data[d->front];
    d->front = (d->front + 1) % MAX_DEQUE;
    d->size--;

    return 1;
}

int dq_pop_back(Deque *d, int *out) {
    if (d->size == 0) {
        return 0;
    }
    *out = d->data[d->rear];
    d->rear = (d->rear - 1 + MAX_DEQUE) % MAX_DEQUE;
    d->size--;

    return 1;
}
void dq_print(Deque *d) {
    printf("[");
    for (int i = 0; i < d->size; ++i) {
        int idx = (d->front + i) % MAX_DEQUE;
        printf("%d", d->data[idx]);
        if (i < d->size-1) {
            printf(", ");
        }
    }
    printf("]\n");
}

/* ---------- Min-heap (priority queue simple) ---------- */
void heap_init(MinHeap *h) { 
    h->size = 0; 
}

static void heap_swap(int *a, int *b) { 
    int t = *a; 
    *a = *b; 
    *b = t; 
}

int heap_push(MinHeap *h, int v) {
    if (h->size >= MAX_QUEUE) {
        return 0;
    }
    int i = h->size++; 
    h->data[i] = v;

    while (i > 0) {
        int p = (i - 1) / 2;
        if (h->data[p] <= h->data[i]) {
            break;
        }
        heap_swap(&h->data[p], &h->data[i]);
        i = p;
    }

    return 1;
}

int heap_pop(MinHeap *h, int *out) {
    if (h->size == 0) {
        return 0;
    }
    *out = h->data[0];
    h->data[0] = h->data[--h->size];

    int i = 0;
    while (1) {
        int l = 2*i+1, r = 2*i+2, smallest = i;
        if (l < h->size && h->data[l] < h->data[smallest]) {
            smallest = l;
        }

        if (r < h->size && h->data[r] < h->data[smallest]) {
            smallest = r;
        
        }

        if (smallest == i) {
            break;
        }
        heap_swap(&h->data[i], &h->data[smallest]);
        i = smallest;
    }

    return 1;
}

void heap_print(MinHeap *h) {
    printf("[");
    for (int i = 0; i < h->size; ++i) {
        printf("%d", h->data[i]);
        if (i < h->size-1) {
            printf(", ");
        }
    }
    printf("]\n");
}

/* ---------- Árboles (BST) ---------- */
TNode* tnode_new(int v) {
    TNode *n = malloc(sizeof(TNode));
    if (!n) {
        return NULL;
    }
    n->val = v; 
    n->left = n->right = NULL; 

    return n;
}

TNode* bst_insert(TNode *root, int v) {
    if (!root) {
        return tnode_new(v);
    }

    if (v < root->val) {
        root->left = bst_insert(root->left, v);
    } else if (v > root->val) {
        root->right = bst_insert(root->right, v);
    }
    /* duplicates ignored */
    return root;
}

TNode* bst_search(TNode *root, int v) {
    if (!root) {
        return NULL;
    }

    if (v == root->val) {
        return root;
    }

    if (v < root->val) {
        return bst_search(root->left, v);
    }

    return bst_search(root->right, v);
}

TNode* bst_find_min(TNode *root) {
    while (root && root->left) {
        root = root->left;
    }

    return root;
}

TNode* bst_delete(TNode *root, int v) {
    if (!root) {
        return NULL;
    }

    if (v < root->val) {
        root->left = bst_delete(root->left, v);
    } else if (v > root->val) {
        root->right = bst_delete(root->right, v);
    } else {
        if (!root->left && !root->right) { 
            free(root); 
            return NULL; 
        }

        if (!root->left) { 
            TNode *r = root->right; 
            free(root); 
            return r; 
        }

        if (!root->right) { 
            TNode *l = root->left; 
            free(root); 
            return l; 
        }

        TNode *minr = bst_find_min(root->right);
        root->val = minr->val;
        root->right = bst_delete(root->right, minr->val);
    }

    return root;
}

void bst_inorder(TNode *root) {
    if (!root) {
        return;
    }

    bst_inorder(root->left);
    printf("%d ", root->val);
    bst_inorder(root->right);
}

void bst_preorder(TNode *root) {
    if (!root) {
        return;
    }

    printf("%d ", root->val);
    bst_preorder(root->left);
    bst_preorder(root->right);
}

void bst_postorder(TNode *root) {
    if (!root) {
        return;
    }

    bst_postorder(root->left);
    bst_postorder(root->right);
    printf("%d ", root->val);
}
void bst_free(TNode *root) {
    if (!root) {
        return;
    }

    bst_free(root->left);
    bst_free(root->right);
    free(root);
}

/* ---------- Grafos (matriz) ---------- */
void am_init(AdjMatrix *g, int n) {
    g->n = n;
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < n; ++j) {
            g->mat[i][j] = 0;
        }
    }
}

void am_add_edge(AdjMatrix *g, int u, int v, int directed) {
    if (u < 0 || v < 0 || u >= g->n || v >= g->n) {
        return;
    }
    g->mat[u][v] = 1;

    if (!directed) {
        g->mat[v][u] = 1;
    }
}

void am_remove_edge(AdjMatrix *g, int u, int v, int directed) {
    if (u < 0 || v < 0 || u >= g->n || v >= g->n) {
        return;
    }
    g->mat[u][v] = 0;

    if (!directed) {
        g->mat[v][u] = 0;
    }
}

void am_print(AdjMatrix *g) {
    for (int i = 0; i < g->n; ++i) {
        for (int j = 0; j < g->n; ++j) {
            printf("%d ", g->mat[i][j]);
        }
        printf("\n");
    }
}

/* ---------- Grafos (lista de adyacencia) ---------- */
void al_init(AdjList *g, int n) {
    g->n = n;
    for (int i = 0; i < n; ++i) {
        g->heads[i] = NULL;
    }
}

void al_add_edge(AdjList *g, int u, int v, int directed) {
    if (u < 0 || v < 0 || u >= g->n || v >= g->n) {
        return;
    }
    GAdjNode *n = malloc(sizeof(GAdjNode));
    n->v = v; 
    n->next = g->heads[u]; 
    g->heads[u] = n;

    if (!directed) {
        GAdjNode *m = malloc(sizeof(GAdjNode));
        m->v = u; 
        m->next = g->heads[v]; 
        g->heads[v] = m;
    }
}

void al_remove_edge(AdjList *g, int u, int v, int directed) {
    if (u < 0 || v < 0 || u >= g->n || v >= g->n) {
        return;
    }
    GAdjNode *it = g->heads[u], *prev = NULL;

    while (it) {
        if (it->v == v) {
            if (prev) {
                prev->next = it->next; 
            } else {
                g->heads[u] = it->next;
            }
            free(it); 
            break;
        }
        prev = it; it = it->next;
    }

    if (!directed) {
        it = g->heads[v]; 
        prev = NULL;

        while (it) {
            if (it->v == u) {
                if (prev) {
                    prev->next = 
                    it->next; 
                } else {
                    g->heads[v] = it->next;
                }
                free(it); 
                break;
            }
            prev = it; it = it->next;
        }
    }
}

void al_print(AdjList *g) {
    for (int i = 0; i < g->n; ++i) {
        printf("%d:", i);
        for (GAdjNode *it = g->heads[i]; it; it = it->next) {
            printf(" %d", it->v);
        }
        printf("\n");
    }
}

void al_free(AdjList *g) {
    for (int i = 0; i < g->n; ++i) {
        GAdjNode *it = g->heads[i];

        while (it) { 
            GAdjNode *t = it->next; 
            free(it); 
            it = t; 
        }
        g->heads[i] = NULL;
    }
}

/* ---------- Tabla hash (encadenamiento) ---------- */
int hash_func(int key) { 
    return (key % HASH_SIZE + HASH_SIZE) % HASH_SIZE; 
}

void ht_init(HashTable *ht) { 
    for (int i = 0; i < HASH_SIZE; ++i) {
        ht->buckets[i] = NULL; 
    }
}

void ht_insert(HashTable *ht, int key) {
    int idx = hash_func(key);
    HNode *n = malloc(sizeof(HNode));

    if (!n) {
        return;
    }
    n->key = key; 
    n->next = ht->buckets[idx]; 
    ht->buckets[idx] = n;
}

int ht_search(HashTable *ht, int key) {
    int idx = hash_func(key);
    for (HNode *it = ht->buckets[idx]; it; it = it->next) {
        if (it->key == key) {
            return 1;
        }
    }

    return 0;
}

void ht_delete(HashTable *ht, int key) {
    int idx = hash_func(key);
    HNode *it = ht->buckets[idx], *prev = NULL;

    while (it) {
        if (it->key == key) {
            if (prev) {
                prev->next = it->next; 
            } else {
                ht->buckets[idx] = it->next;
            }
            free(it); 
            return;
        }
        prev = it; it = it->next;
    }
}

void ht_print(HashTable *ht) {
    for (int i = 0; i < HASH_SIZE; ++i) {
        printf("%d:", i);
        for (HNode *it = ht->buckets[i]; it; it = it->next) {
            printf(" %d", it->key);
        }
        printf("\n");
    }
}

void ht_free(HashTable *ht) {
    for (int i = 0; i < HASH_SIZE; ++i) {
        HNode *it = ht->buckets[i];

        while (it) { 
            HNode *t = it->next; 
            free(it); 
            it = t; 
        }
        ht->buckets[i] = NULL;
    }
}

/* ---------- Utiles ---------- */
int read_int(const char *prompt) {
    int v;
    printf("%s", prompt);
    if (scanf("%d", &v) != 1) { /* clear input on bad read */
        int c; while ((c = getchar()) != EOF && c != '\n'); return 0;
    }
    return v;
}

/* ---------- Menú demostrativo principal (simplificado) ---------- */
void menu_all(void) {
    int opt = -1;
    /* We'll keep small demo instances of each DS */
    SNode *slist = NULL;
    DNode *dlist = NULL; /* tail or head ambiguous; use head semantics as needed */
    CDNode *cdtail = NULL;
    CNode *cstail = NULL;

    ArrayStack ast; astack_init(&ast);
    LNode *lstack = NULL;

    SimpleQueue sq; sq_init(&sq);
    CircQueue cq; cq_init(&cq);
    Deque dq; dq_init(&dq);
    MinHeap mh; heap_init(&mh);

    TNode *bst = NULL;

    AdjMatrix am; am_init(&am, 5);
    AdjList al; al_init(&al, 5);

    HashTable ht; ht_init(&ht);

    while (1) {
        printf("\n=== ESTRUCTURAS (demo) ===\n");
        printf("1 Listas (simple/doble/circ simple/double)\n");
        printf("2 Pilas (array/lista)\n");
        printf("3 Colas (simple/circular/deque/priority)\n");
        printf("4 Arboles (BST)\n");
        printf("5 Grafos (matriz/lista)\n");
        printf("6 Tabla Hash (encadenamiento)\n");
        printf("0 Salir\n");
        printf("Elige: ");
        if (scanf("%d", &opt) != 1) { 
            while (getchar()!='\n'); 
            opt = -1; 
            continue; 
        }

        if (opt == 0) {
            break;
        }

        if (opt == 1) {
            int sub;
            printf("\n--- Listas ---\n1 Simple 2 Doble 3 CircSimple 4 CircDoble 0 Volver\nElige: ");
            scanf("%d", &sub);
            if (sub == 1) {
                printf("Lista simple: insert front(1) insert end(2) delete val(3) print(4)\nElige: ");
                int a; 
                scanf("%d", &a);

                if (a==1) { 
                    int v = read_int("val: "); 
                    slist = s_insert_front(slist, v); 
                } else if (a==2) { 
                    int v = read_int("val: "); 
                    slist = s_insert_end(slist, v); 
                } else if (a==3) { 
                    int v = read_int("val: "); 
                    slist = s_delete_val(slist, v); 
                } else if (a==4) {
                    s_print(slist);
                }

            } else if (sub == 2) {
                printf("Lista doble: insert end(1) delete val(2) print forward(3)\nElige: ");
                int a; 
                scanf("%d", &a);

                if (a==1) { 
                    int v = read_int("val: "); 
                    if (!dlist) {
                        dlist = d_insert_end(NULL, v); 
                    } else {
                        dlist = d_insert_end(dlist, v); 
                    }
                } else if (a==2) { 
                    int v = read_int("val: "); 
                    dlist = d_delete_val(dlist, v); 
                } else if (a==3) {
                    d_print_forward(dlist);
                }

            } else if (sub == 3) {
                printf("Circ simple: insert end(1) delete val(2) print(3)\nElige: ");
                int a; 
                scanf("%d", &a);

                if (a==1) { 
                    int v = read_int("val: "); 
                    cstail = cs_insert_end(cstail, v); 
                } else if (a==2) { 
                    int v = read_int("val: "); 
                    cstail = cs_delete_val(cstail, v); 
                } else if (a==3) {
                    cs_print(cstail);
                }

            } else if (sub == 4) {
                printf("Circ doble: insert end(1) delete val(2) print(3)\nElige: ");
                int a; 
                scanf("%d", &a);

                if (a==1) { 
                    int v = read_int("val: "); 
                    cdtail = cd_insert_end(cdtail, v); 
                } else if (a==2) { 
                    int v = read_int("val: "); 
                    cdtail = cd_delete_val(cdtail, v); 
                } else if (a==3) {
                    cd_print(cdtail);
                }
            }

        } else if (opt == 2) {
            printf("\n--- Pilas ---\n1 Array push 2 Array pop 3 Array print\n4 List push 5 List pop 6 List print\nElige: ");
            int a; 
            scanf("%d", &a);

            if (a==1) { 
                int v = read_int("val: "); 
                astack_push(&ast, v); 
            } else if (a==2) { 
                int out; 
                if (astack_pop(&ast, &out)) {
                    printf("pop=%d\n", out); 
                } else {
                    printf("empty\n"); 
                }
            } else if (a==3) {
                astack_print(&ast);
            } else if (a==4) { 
                int v = read_int("val: "); 
                lstack = lstack_push(lstack, v); 
            } else if (a==5) { 
                int out; 
                if (lstack) { 
                    lstack = lstack_pop(lstack, &out); 
                    printf("pop=%d\n", out); 
                } else {
                    printf("empty\n"); 
                }
            } else if (a==6) {
                lstack_print(lstack);
            }

        } else if (opt == 3) {
            printf("\n--- Colas ---\n1 Simple enqueue 2 Simple dequeue 3 Simple print\n4 Circular enqueue 5 Circular dequeue 6 Circular print\n7 Deque push_front 8 Deque push_back 9 Deque pop_front 10 Deque pop_back 11 Deque print\n12 Heap push 13 Heap pop 14 Heap print\nElige: ");
            int a; 
            scanf("%d", &a);

            if (a==1) { 
                int v = read_int("val: "); 
                sq_enqueue(&sq, v); 
            } else if (a==2) { 
                int out; 
                if (sq_dequeue(&sq, &out)) {
                    printf("deq=%d\n", out); 
                } else {
                    printf("empty\n"); 
                }
            } else if (a==3) {
                sq_print(&sq);
            } else if (a==4) { 
                int v = read_int("val: "); 
                cq_enqueue(&cq, v); 
            } else if (a==5) { 
                int out; 
                if (cq_dequeue(&cq, &out)) {
                    printf("deq=%d\n", out); 
                } else {
                    printf("empty\n"); 
                }
            } else if (a==6) {
                cq_print(&cq);
            } else if (a==7) { 
                int v = read_int("val: "); 
                dq_push_front(&dq, v); 
            } else if (a==8) { 
                int v = read_int("val: "); 
                dq_push_back(&dq, v); 
            } else if (a==9) { 
                int out; 
                if (dq_pop_front(&dq, &out)) {
                    printf("popf=%d\n", out); 
                } else {
                    printf("empty\n"); 
                }
            } else if (a==10) { 
                int out; 
                if (dq_pop_back(&dq, &out)) {
                    printf("popb=%d\n", out); 
                } else {
                    printf("empty\n"); 
                }
            } else if (a==11) {
                dq_print(&dq);
            } else if (a==12) { 
                int v = read_int("val: "); 
                heap_push(&mh, v); 
            } else if (a==13) { 
                int out; 
                if (heap_pop(&mh, &out)) {
                    printf("pop=%d\n", out); 
                } else {
                    printf("empty\n"); 
                }
            } else if (a==14) {
                heap_print(&mh);
            }

        } else if (opt == 4) {
            printf("\n--- BST ---\n1 Insert 2 Search 3 Delete 4 Inorder 5 Preorder 6 Postorder\nElige: ");
            int a; 
            scanf("%d", &a);

            if (a==1) { 
                int v = read_int("val: "); 
                bst = bst_insert(bst, v); 
            } else if (a==2) { 
                int v = read_int("val: "); 
                printf(bst_search(bst, v) ? "Found\n" : "Not found\n"); 
            } else if (a==3) { 
                int v = read_int("val: "); 
                bst = bst_delete(bst, v); 
            } else if (a==4) { 
                bst_inorder(bst); 
                printf("\n"); 
            } else if (a==5) { 
                bst_preorder(bst); 
                printf("\n"); 
            } else if (a==6) { 
                bst_postorder(bst); 
                printf("\n"); 
            }

        } else if (opt == 5) {
            printf("\n--- Grafos ---\n1 AM add 2 AM remove 3 AM print\n4 AL add 5 AL remove 6 AL print\nElige: ");
            int a; 
            scanf("%d", &a);

            if (a==1) { 
                int u = read_int("u: "); 
                int v = read_int("v: "); 
                int d = read_int("directed? 0/1: "); 
                am_add_edge(&am,u,v,d); 
            } else if (a==2) { 
                int u = read_int("u: "); 
                int v = read_int("v: "); 
                int d = read_int("directed? 0/1: "); 
                am_remove_edge(&am,u,v,d); 
            } else if (a==3) {
                am_print(&am);
            } else if (a==4) { 
                int u = read_int("u: "); 
                int v = read_int("v: "); 
                int d = read_int("directed? 0/1: "); 
                al_add_edge(&al,u,v,d); 
            } else if (a==5) { 
                int u = read_int("u: "); 
                int v = read_int("v: "); 
                int d = read_int("directed? 0/1: "); 
                al_remove_edge(&al,u,v,d); 
            } else if (a==6) {
                al_print(&al);
            }

        } else if (opt == 6) {
            printf("\n--- Hash Table (chaining) ---\n1 Insert 2 Search 3 Delete 4 Print\nElige: ");
            int a; 
            scanf("%d", &a);

            if (a==1) { 
                int k = read_int("key: "); 
                ht_insert(&ht, k); 
            } else if (a==2) { 
                int k = read_int("key: "); 
                printf(ht_search(&ht,k) ? "Found\n" : "Not found\n"); 
            } else if (a==3) { 
                int k = read_int("key: "); 
                ht_delete(&ht, k); 
            } else if (a==4) {
                ht_print(&ht);
            }
        }
    }

    /* liberar recursos al salir */
    s_free(slist); 
    d_free(dlist); 
    cs_free(cstail); 
    cd_free(cdtail);
    lstack_free(lstack); 
    sq_free(&sq); /* cq, dq, mh no requieren free de heap */
    bst_free(bst); 
    al_free(&al); 
    ht_free(&ht);
    printf("Saliendo...\n");
}

int main(void) {
    menu_all();
    return 0;
}

//FIRMAS
int read_int(const char *prompt);
SNode* s_insert_front(SNode *head, int v);
SNode* s_insert_end(SNode *head, int v);
SNode* s_delete_val(SNode *head, int v);
SNode* s_search(SNode *head, int v);
void s_print(SNode *head);
void s_free(SNode *head);
DNode* d_insert_end(DNode *tail_ref, int v);
DNode* d_delete_val(DNode *head, int v);
void d_print_forward(DNode *head);
void d_print_backward(DNode *tail);
void d_free(DNode *head);
CNode* cs_insert_end(CNode *tail, int v);
CNode* cs_delete_val(CNode *tail, int v);
void cs_print(CNode *tail);
void cs_free(CNode *tail);
CDNode* cd_insert_end(CDNode *tail, int v);
CDNode* cd_delete_val(CDNode *tail, int v);
void cd_print(CDNode *tail);
void cd_free(CDNode *tail);
void astack_init(ArrayStack *s);
int astack_push(ArrayStack *s, int v);
int astack_pop(ArrayStack *s, int *out);
void astack_print(ArrayStack *s);
LNode* lstack_push(LNode *head, int v);
LNode* lstack_pop(LNode *head, int *out);
void lstack_print(LNode *head);
void lstack_free(LNode *head);
void sq_init(SimpleQueue *q);
int sq_enqueue(SimpleQueue *q, int v);
int sq_dequeue(SimpleQueue *q, int *out);
void sq_print(SimpleQueue *q);
void sq_free(SimpleQueue *q);
void cq_init(CircQueue *q);
int cq_dequeue(CircQueue *q, int *out);
void cq_print(CircQueue *q);
void dq_init(Deque *d);
int dq_push_front(Deque *d, int v);
int dq_push_back(Deque *d, int v);
int dq_pop_front(Deque *d, int *out);
int dq_pop_back(Deque *d, int *out);
void dq_print(Deque *d);
void heap_init(MinHeap *h);
static void heap_swap(int *a, int *b);
int heap_push(MinHeap *h, int v);
int heap_pop(MinHeap *h, int *out);
void heap_print(MinHeap *h);
TNode* tnode_new(int v);
TNode* bst_insert(TNode *root, int v);
TNode* bst_search(TNode *root, int v);
TNode* bst_find_min(TNode *root);
TNode* bst_delete(TNode *root, int v);
void bst_inorder(TNode *root);
void bst_preorder(TNode *root);
void bst_postorder(TNode *root);
void bst_free(TNode *root);
void am_init(AdjMatrix *g, int n);
void am_add_edge(AdjMatrix *g, int u, int v, int directed);
void am_remove_edge(AdjMatrix *g, int u, int v, int directed);
void am_print(AdjMatrix *g);
void al_init(AdjList *g, int n);
void al_add_edge(AdjList *g, int u, int v, int directed);
void al_remove_edge(AdjList *g, int u, int v, int directed);
void al_print(AdjList *g);
void al_free(AdjList *g);
int hash_func(int key);
void ht_init(HashTable *ht);
void ht_insert(HashTable *ht, int key);
int ht_search(HashTable *ht, int key);
void ht_delete(HashTable *ht, int key);
void ht_print(HashTable *ht);
void ht_free(HashTable *ht);
int read_int(const char *prompt);
void menu_all(void);